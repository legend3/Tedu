package com.tarena.oss.service;

import com.tarena.oss.entity.Admin;
/**
 * 业务层接口。
 */
public interface LoginService {
	public Admin checkLogin(String code,
			String pwd);
}
