package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	public DemoServlet() {
		System.out.println("创建DemoServlet");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		/**
		 * ServletConfig对象对应web.xml文件中的<servlet>元素。
		 * 例如你想获取当前Servlet在web.xml文件中的配置名，那么可以使用servletConfig.getServletName()方法获取！
		 * 你不能自己去创建ServletConfig对象，Servlet的init()方法的参数就是ServletConfig类型的。
		 * Tomcat在调用init()方法时，会传递ServletConfig对象。你可以在init()方法中使用它！
		 */
		super.init(config);
		System.out.println("初始化DemoServlet");//<load-on-startup>1</load-on-startup>负责启调用！
												//因此可以在此阶段通过ServletContext初始化项目所需要的全局变量
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//核心
		ServletContext ctx = getServletContext(); 
		System.out.println("调用DemoServlet,输出变量: " + ctx.getAttribute("count"));//本全局变量是在initServlet中初始化配置的
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁DemoServlet");//热部署修改类内容时后会自动重新调用此类的Serlet，会自动触发destroy
	}
	
	
	
	
	
}






