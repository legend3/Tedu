package com.tarena.oss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.oss.entity.Admin;
/**
 * DAO实现类。
 * 
 */
@Repository("adminDAO")
public class AdminDAOJdbcImpl implements 
AdminDAO{
	
	@Resource(name="ds")
	//使用依赖注入的方式注入DataSource。
	private DataSource ds;
	
	public Admin findByAdminCode(String code) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM "
					+ "admin_info_lhh "
					+ "WHERE admin_code=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			//记日志
			e.printStackTrace();
			/*
			 * 看异常能否恢复，如果
			 * 不能够恢复(发生了系统异常，比如
			 * 数据库服务暂停,网络中断等等),
			 * 则提示用户稍后重试。如果能够
			 * 恢复，则立即恢复。
			 */
			throw new RuntimeException(e);
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return admin;
	}
	
	
	
	

}
