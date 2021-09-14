package com.tarena.oss.dao;

import java.sql.SQLException;

import com.tarena.oss.entity.Admin;

/**
 * DAO接口：
 * 声明一系列数据访问方法。
 * 注意：
 * 	 这些方法不应该涉及任何具体的实现技术。
 */
public interface AdminDAO {
	public Admin findByAdminCode(String code);
}




