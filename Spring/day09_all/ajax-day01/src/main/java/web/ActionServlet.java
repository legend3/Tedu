package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest 
			request,
			HttpServletResponse response) 
	throws ServletException,IOException{
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		//获取请求资源路径。 
		String uri = 
				request.getRequestURI();
		System.out.println("uri:" + uri);
		String action = 
				uri.substring(
						uri.lastIndexOf("/"),
						uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if("/check_uname".equals(action)){
			//检查用户名是否存在
			String username = 
					request.getParameter(
							"username");
			System.out.println("username:" 
							+ username);
			//假设数据库里面有一个用户Tom
			if("Tom".equals(username)){
				out.println("用户名被占用了");
			}else{
				out.println("可以使用");
			}
		}
		
	}
}




