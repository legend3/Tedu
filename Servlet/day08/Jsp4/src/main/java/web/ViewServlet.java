package web;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//浏览器再次访问该项目时，会自动将之前的cookie传入。
		Cookie[] cs = req.getCookies();//获取客户端全部Cookie(未过期)
		if(cs != null) {
			for(Cookie c : cs) {
				System.out.println(
					c.getName() + ":" +
						URLDecoder.decode(
							c.getValue(), "UTF-8"));
			}
		}
		//转发到JSP，在此JSP上依然可以获取cookie
		//当前：/Jsp4/aa/view
		//目标：/Jsp4/WEB-INF/view.jsp
		req.getRequestDispatcher("../WEB-INF/view.jsp").forward(req, res);
	}
}
