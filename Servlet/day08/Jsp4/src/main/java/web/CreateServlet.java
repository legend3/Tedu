package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//创建cookie，每个cookie内只能存
		//一个String类型的数据。
		Cookie c1 = new Cookie(
			"user","zhangsan");
		//设置cookie过期时间，此cookie将被
		//浏览器存到硬盘上，超出时间后自动删除。
		c1.setMaxAge(60000);
		//将cookie发送给浏览器
		res.addCookie(c1);
		
		//cookie中默认不能存中文，
		//必须对中文编码后才能保存。
		Cookie c2 = new Cookie("city",
			URLEncoder.encode("北京", "utf-8"));
		res.addCookie(c2);
		
	}

	
	
}







