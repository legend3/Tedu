package day02.jdbc.src.test.java.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class TestDay02 {
	
	/**
	 * 模拟转账的业务：
	 * 	假设用户已经登录ATM
	 * 	1.验证收款方账号是否正确(查)
	 * 	2.验证付款方余额是否够用(查)
	 * 	3.付款方余额-N元(改)
	 * 	4.收款方余额+N元(改)
	 */
	@Test
	public void test7() {
		//假设登录时输入的付款账号为
		String payId = "00001";
		//假设输入的收款账号为
		String recId = "00002";
		//假设输入的转账金额为
		double mny = 2000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//1.验证收款账号
			String sql = 
				"select * from accounts_lhh "
				+ "where id=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, recId);
			ResultSet rs = ps.executeQuery();
			double recMoney = 0;
			if(!rs.next()) {
				System.out.println("收款账号错误");
				throw new SQLException("收款账号错误");
			} else {
				//记录收款账号余额
				recMoney = rs.getDouble("money");
			}
			//2.验证付款余额
			sql = "select * from accounts_lhh "
					+ "where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, payId);
			rs = ps.executeQuery();
			//因为已经登录了，所以账号必然存在
			rs.next();
			double payMoney = rs.getDouble("money");
			if(payMoney<mny) {
				System.out.println("余额不足");
				throw new SQLException("余额不足");
			}
			
			//取消自动提交事务
			con.setAutoCommit(false);
			
			//3.付款账号余额-N元
			sql = "update accounts_lhh set "
					+ "money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, payMoney-mny);
			ps.setString(2, payId);
			ps.executeUpdate();
			
			//假设此处有意外(断电/断网/异常)
			Integer.valueOf("abc");
			
			//4.收款账号余额+N元
			sql = "update accounts_lhh set "
					+ "money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, recMoney+mny);
			ps.setString(2, recId);
			ps.executeUpdate();
			
			//3、4步都完成后手动提交事务
			con.commit();
		} catch (Exception e) {
			//发生异常时回滚事务
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(
				"转账失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 了解ResultSetMetaData结构
	 */
	@Test
	public void test6() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			//获得结果集元数据
			ResultSetMetaData md = rs.getMetaData();
			//输出元数据的内容
			//结果集有多少列
			System.out.println(md.getColumnCount());
			//第1列的字段名
			System.out.println(md.getColumnName(1));
			//第1列对应的Java类型
			System.out.println(md.getColumnClassName(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 使用PreparedStatement避免注入攻击
	 */
	@Test
	public void test5() {
		//假设用户登录时传入了如下的数据
		String name = "zhangsan";
		String pwd = "a' or 'b'='b";
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from users_lhh "
				+ "where username=? "
				+ "and password=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println(
					"账号或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询用户失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 使用PreparedStatement修改
	 */
	@Test
	public void test4() {
		//假设用户传入以下要修改的数据
		int empno = 33; //悟空的ID
		String ename = "八戒";
		String job = "吃货";
		double sal = 5000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update emps_lhh set "
				+ "ename=?,"
				+ "job=?,"
				+ "sal=? "
				+ "where empno=?";
			PreparedStatement ps = con.prepareStatement(sql);//带参数！
			ps.setString(1, ename);//配置参数
			ps.setString(2, job);
			ps.setDouble(3, sal);
			ps.setInt(4, empno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改员工失败", e);
		} finally {
			DBUtil.close(con);
		}
		
	}
	
	/**
	 * 使用PreparedStatement增加
	 */
	@Test
	public void test3() {
		//假设用户传入的数据如下
		String ename = "悟空";
		String job = "保镖";
		int mgr = 27;
		//java.sql.Date
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 3000.0;
		double comm = 200.0;
		int deptno = 2;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"insert into emps_lhh "
				+ "values(emps_seq_lhh.nextval,"
				+ "?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"增加员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 使用PreparedStatement查询
	 */
	@Test
	public void test2() {
		//假设用户传入了如下查询条件
		int deptno = 1;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh "
				+ "where deptno=?";
			//创建ps时传入SQL以便于尽早编译SQL
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//给?设置参数值
			//ps.set类型(?的索引,?的值)
			ps.setInt(1, deptno);
			//发送参数，运行计划
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getInt("empno"));
				System.out.println(
					rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 使用Statement执行DQL
	 */
	@Test
	public void test1() {
		//假设用户传入了如下查询条件
		double sal = 5000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			Statement smt = con.createStatement();
			String sql = 
				"select * from emps_lhh "
				+ "where sal>"+sal;
			//executeQuery返回查询的结果集ResultSet，
			//该对象采用了迭代器模式进行设计，
			//这种模式一般都采用while进行遍历。
			ResultSet rs = smt.executeQuery(sql);
			//每次next得到下一行数据
			while(rs.next()) {
				//rs.get类型(字段名) -> 字段值
				//rs.get类型(字段序号) -> 字段值
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				System.out.println(empno+","+ename);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

}









