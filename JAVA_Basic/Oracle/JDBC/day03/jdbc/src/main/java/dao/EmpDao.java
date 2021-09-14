package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class EmpDao {

	/**
	 * 新增员工
	 */
	public void save(Emp emp) {
		
	}
	
	/**
	 * 修改员工
	 * @param emp 
	 * 	empno是旧的值，其他属性是改后的值。
	 */
	public void update(Emp emp) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"update emps_lhh set "
				+ "ename=?,"
				+ "job=?,"
				+ "mgr=?,"
				+ "hiredate=?,"
				+ "sal=?,"
				+ "comm=?,"
				+ "deptno=? "
				+ "where empno=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"修改员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 根据ID删除员工
	 */
	public void delete(int id) {
		
	}
	
	/**
	 * 分页查询员工
	 * @param page 页码
	 * @param size 每页显示条目数
	 * @return 员工集合
	 * Alt+Shift+J
	 */
	public List<Emp> findByPage(
			int page, int size) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from ("
				+ " select e.*,rownum r from ("
				+ "   select * from emps_lhh "
				+ "   order by empno"
				+ " ) e"
				+ ") where r between ? and ?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, (page-1)*size+1);
			ps.setInt(2, page*size);
			ResultSet rs = ps.executeQuery();
			//使用集合封装多个员工对象
			List<Emp> list = new ArrayList<Emp>();
			while(rs.next()) {
				//结果集中每一行数据就是一个员工，
				//使用一个Emp来封装这个员工。
				Emp e = createEmp(rs);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"分页查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

	/**
	 * Alt+Shift+M
	 */
	private Emp createEmp(ResultSet rs) throws SQLException {
		Emp e = new Emp();
		e.setEmpno(rs.getInt("empno"));
		e.setEname(rs.getString("ename"));
		e.setJob(rs.getString("job"));
		e.setMgr(rs.getInt("mgr"));
		e.setHiredate(rs.getDate("hiredate"));
		e.setSal(rs.getDouble("sal"));
		e.setComm(rs.getDouble("comm"));
		e.setDeptno(rs.getInt("deptno"));
		return e;
	}
	
	/**
	 * 根据ID查询员工
	 * @param id 主键
	 * @return 员工对象
	 */
	public Emp findById(int id) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from emps_lhh "
				+ "where empno=?";
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return createEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"根据ID查询员工失败", e);
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
}







