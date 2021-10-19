package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbcServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//各种获取路径的方式
		System.out.println(req.getContextPath());//项目路径
		System.out.println(req.getServletPath());//相对路径
		System.out.println(req.getRequestURI());//绝对路径
		System.out.println(req.getRequestURL());//完整路径
		
		
		//如果不输出响应信息，则服务器会自动响应，
		//但内容为空，浏览器看到一片空白。
	}

	
	
}












