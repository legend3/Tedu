package com.tarena.oss.service;

import com.tarena.oss.entity.Admin;

/**
 * 业务层接口：
 *
 */
public interface LoginService {
	
	/**
	 * 依据帐号(code)和密码(pwd)，查询
	 * 数据库，如果有满足条件的记录，则
	 * 返回一个完整的Admin对象。否则返回
	 * null。
	 */
	public Admin checkLogin(String code,
			String pwd);
	
}
