package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *	通常在Tomcat启动时每次调用某Servlet时，
 *	专门用来在此阶段初始化项目所需要的变量。
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化流量count(利用ServletContext存、取预置数据)
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
		System.out.println("load-on-startup 2:" + ctx.getAttribute("count"));//<load-on-startup>2</load-on-startup>负责调用

	}

	
	
}










