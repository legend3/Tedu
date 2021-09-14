package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//从session中取值
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		System.out.println(obj.toString());
		//转发到JSP
		// /Jsp5/view
		// /Jsp5/WEB-INF/view.jsp
		req.getRequestDispatcher(
			"WEB-INF/view.jsp")
			.forward(req, res);
	}

	
	
}





