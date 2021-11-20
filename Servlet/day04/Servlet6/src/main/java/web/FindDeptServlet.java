package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//从web.xml中读取分页条件
		ServletContext ctx = getServletContext();
		String size = ctx.getInitParameter("size");//获取<context-param>中全局变量
		//分页查询
		System.out.println(size);
		//统计流量
		Object obj = ctx.getAttribute("count");//获取init()方法中设置的变量
		int count = Integer.parseInt(obj.toString());
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

	
	
}






