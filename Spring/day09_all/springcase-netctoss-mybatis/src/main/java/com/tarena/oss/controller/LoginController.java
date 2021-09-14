package com.tarena.oss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.oss.entity.Admin;
import com.tarena.oss.service.ApplicationException;
import com.tarena.oss.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		//跳转到登录页面
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(
			HttpServletRequest request){
		System.out.println(
				"LoginController's login()");
		//读取用户提交的帐号和密码
		String adminCode = 
				request.getParameter("adminCode");
		String pwd = 
				request.getParameter("pwd");
		//调用业务层代码完成登录请求
		Admin admin = 
				loginService.checkLogin(
						adminCode, pwd);
		//登录成功，重定向到首页。
		return "redirect:toIndex.do";
	}
	
	@ExceptionHandler
	//异常处理方法。
	public String execute(Exception ex,
			HttpServletRequest request){
		if(ex instanceof ApplicationException){
			//应用异常，明确提示用户采取正确的操作
			request.setAttribute("login_failed",
					ex.getMessage());
			return "login";
		}
		//系统异常，提示用户稍后重试。
		return "error";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	
	
}
