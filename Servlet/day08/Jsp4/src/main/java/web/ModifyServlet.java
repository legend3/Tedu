package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		Cookie[] cs = req.getCookies();
		if(cs != null) {
			for(Cookie c : cs) {
				//找出要修改的cookie
				if(c.getName().equals("user")) {
					//修改它
					c.setValue("lisi");
					//发送给浏览器
					res.addCookie(c);
				}
			}
		}
	}

	
	
}









