package com.tarena.oss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.oss.entity.Admin;
import com.tarena.oss.service.ApplicationException;
import com.tarena.oss.service.LoginService;

/**
 * 处理器。
 *	客户端的请求先发送给DispatcherServlet,
 *  DispatcherServlet会调用Controller来处理。
 *  
 *	处理器可以调用业务层代码来处理请求。
 */
@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpSession session){
		System.out.println("LoginController's login()");
		//读取帐号和密码
		String adminCode = request.getParameter("adminCode");
		System.out.println("adminCode:" + adminCode);
		String pwd = request.getParameter("pwd");
		//调用业务层代码来完成登录处理
		try{
			Admin admin = loginService.checkLogin(adminCode, pwd);
			//将admin对象绑订到session。
			session.setAttribute("admin", admin);
		}catch(Exception e){
			e.printStackTrace();
			if(e instanceof ApplicationException){
				//应用异常
				request.setAttribute("login_failed", e.getMessage());
				//转发到登录页面
				return "login";
			}
			//系统异常
			return "error";
		}
		//登录成功，重定向主页。
		
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	
}
