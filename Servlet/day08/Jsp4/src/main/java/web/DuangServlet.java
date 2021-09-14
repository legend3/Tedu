package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DuangServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		Cookie c3 = new Cookie(
			"company", "Tarena");
		//设置cookie的生效路径，它将在此路径
		//及其下级路径下有效。
		c3.setPath(req.getContextPath());
		res.addCookie(c3);
	}
	
}







