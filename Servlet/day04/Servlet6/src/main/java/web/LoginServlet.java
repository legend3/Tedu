package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
	/**
	 * 1.Tomcat在创建此Servlet后，会自动创建
	 *   ServletConfig对象。
	 * 2.Tomcat会调用此对象，读取web.xml中
	 *   给当前Servlet所配置的参数。
	 * 3.Tomcat会自动调用init方法，并传入
	 *   已创建好的ServletConfig对象。
	 * 归纳：调用init方法前，创建config并读取数据。
	 *   在init及其后面的方法内可以使用config。
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String mo = config.getInitParameter("maxOnline");
		System.out.println(mo);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//从web.xml中读取参数
		ServletConfig cfg = getServletConfig();
		String mo = cfg.getInitParameter("maxOnline");
		//判断最大在线人数
		System.out.println(mo);
	}
}





