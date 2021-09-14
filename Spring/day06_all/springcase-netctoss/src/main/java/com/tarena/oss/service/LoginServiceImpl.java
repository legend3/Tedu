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
public class LoginServiceImpl implements 
LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	
	public Admin checkLogin(String code, 
			String pwd) {
		//依据帐号(code),查询数据库
			Admin admin = 
				adminDAO.findByAdminCode(code);
		//如果找不到对应的记录,需要提示用户
		//帐号错误。
		if(admin == null){
			//抛出一个应用异常(
			//用户不正确的操作引起的异常，
			//需要明确提示用户采取正确的操作)。
			throw new ApplicationException(
					"帐号错误");
		}
		//比较密码是否一致。
		if(!admin.getPassword().equals(pwd)){
			//如果密码不一致，提示用户密码错误。
			throw new ApplicationException(
					"密码错误");
		}
		//登录成功
		return admin;
	}
	
	
	
	
	
	

}
