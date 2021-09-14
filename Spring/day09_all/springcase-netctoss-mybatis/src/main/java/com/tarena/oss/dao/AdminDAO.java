package com.tarena.oss.dao;

import com.tarena.oss.entity.Admin;
/**
 * Mapper接口
 *
 */
public interface AdminDAO {
	public Admin findByAdminCode(String code);
}
