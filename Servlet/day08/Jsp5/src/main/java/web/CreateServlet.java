package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//获取session
		HttpSession session = req.getSession();
		//向session中存入数据
		//可以是任意类型的数据
		session.setAttribute("user", "张三");
		//响应时服务器自动将SESSIONID
		//发送给浏览器，浏览器存入cookie。
	}
	
}





