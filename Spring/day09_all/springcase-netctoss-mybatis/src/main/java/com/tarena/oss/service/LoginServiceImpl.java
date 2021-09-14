package com.tarena.oss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tarena.oss.dao.AdminDAO;
import com.tarena.oss.entity.Admin;

/**
 * 业务层实现类
 *
 */
@Service("loginService")
public class LoginServiceImpl 
implements LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	
	public Admin checkLogin(
			String code, String pwd) {
		Admin admin = null;
		admin = adminDAO.findByAdminCode(code);
		if(admin == null){
			//帐号不存在
			throw new ApplicationException(
					"帐号错误");
		}
		if(!admin.getPassword().equals(pwd)){
			//密码不一致
			throw new ApplicationException(
					"密码错误");
		}
		return admin;
	}
	
}
