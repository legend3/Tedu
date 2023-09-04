package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import dao.EmpDao;
import entity.Emp;
import org.testng.annotations.Test;
import util.DBUtil;

public class TestDay03 {
	
	/**
	 * 测试EmpDao.findById()
	 * 测试EmpDao.update()
	 */
	@Test
	public void test5() {
		//假设用户传入的ID为
		int id = 21;
		
		EmpDao dao = new EmpDao();
		Emp e = dao.findById(id);
		if(e != null) {
			System.out.println(
				e.getEmpno()+","+
				e.getEname()+","+
				e.getSal());
		}
		
		//假设用户对此数据做了如下的改动
		e.setEname("王五");
		e.setSal(6000.0);
		dao.update(e);
	}
	
	/**
	 * 测试EmpDao.findByPage()
	 */
	@Test
	public void test4() {
		//假设用户输入的页码是
		int page = 1;
		//假设每页显示条目数的常量为
		int size = 10;
		
		EmpDao dao = new EmpDao();
		List<Emp> list = 
			dao.findByPage(page, size);
		for(Emp e : list) {
			System.out.println(
				e.getEmpno()+","+
				e.getEname()+","+
				e.getSal());
		}
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void test3() {
		//假设需求规定了每页条目数为
		int size = 10;
		//假设当前用户点击的页码为
		int page = 1;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ " select e.*,rownum r from ("
				+ "	  select * from emps_lhh "
				+ "   order by empno"
				+ " ) e"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(
					rs.getInt("empno")+","+
					rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"分页查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 获取自动生成的主键：
	 * 1.增加部门
	 * 2.获取部门ID
	 * 3.增加员工
	 */
	@Test
	public void test2() {
		//假设传入的部门数据如下：
		String dname = "财务部";
		String loc = "天津";
		//假设传入的员工数据如下：
		String ename = "张三丰";
		String job = "经理";
		int mgr = 0;
		Date hiredate = new Date(
			System.currentTimeMillis());
		double sal = 8000.0;
		double comm = 2000.0;
		
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			//插入部门
			String sql = 
				"insert into depts_lhh "
				+ "values(depts_seq_lhh.nextval,?,?)";
			//数组中指定需要ps记录的字段名
			PreparedStatement ps = 
				con.prepareStatement(
					sql, new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			
			//获取刚插入的部门的ID
			//结果集中只有一条数据，
			//该行内存的就是我们指定的字段的值。
			//这种场景下必须用这个方法取值：
			//rs.get类型(索引)
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int deptno = rs.getInt(1);
			
			//插入员工
			sql = "insert into emps_lhh "
					+ "values(emps_seq_lhh.nextval,"
					+ "?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, job);
			ps.setInt(3, mgr);
			ps.setDate(4, hiredate);
			ps.setDouble(5, sal);
			ps.setDouble(6, comm);
			ps.setInt(7, deptno);
			ps.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(
				"新增部门和员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 批量添加108个员工
	 */
	@Test
	public void test1() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			//这是一个完整的业务，要保证一个事务
			con.setAutoCommit(false);
			
			String sql = 
				"insert into emps_lhh "
				+ "values(emps_seq_lhh.nextval,"
				+ "?,?,?,?,?,?,?)";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			for(int i=1;i<=108;i++) {
				ps.setString(1, "好汉"+i);
				ps.setString(2, "打劫");
				ps.setInt(3, 0);
				ps.setDate(4, new Date(
					System.currentTimeMillis()));
				ps.setDouble(5, 
					Math.random()*10000);
				ps.setDouble(6, 
					Math.random()*1000);
				ps.setInt(7, 5);
				
				//将本条数据暂存到ps里
				ps.addBatch();
				//每30条提交一批
				if(i%30==0) {
					ps.executeBatch();
					//清空数据以备处理下一批数据
					ps.clearBatch();
				}
			}
			
			//避免有零头，单独提交一次
			ps.executeBatch();
			
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(
				"批量插入员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

}









