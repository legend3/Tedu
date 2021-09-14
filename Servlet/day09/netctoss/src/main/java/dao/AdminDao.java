package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admin;
import util.DBUtil;

public class AdminDao {
	
	/**
	 * 根据账号查询管理员
	 * @param adminCode 账号
	 */
	public Admin findByCode(String adminCode) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = 
				"select * from admin_info "
				+ "where admin_code=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Admin a = new Admin();
				a.setAdminId(rs.getInt("admin_id"));
				a.setAdminCode(rs.getString("admin_code"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("telephone"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getTimestamp("enrolldate"));
				return a;
			}
		} catch(Exception e) {
			throw new RuntimeException("查询管理员失败", e);
		} finally {
			DBUtil.close(con);
		}
		return null;
	}
	
	public static void main(String[] args) {
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode("caocao");
		System.out.println(a.getName());
	}

}











