package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	/**
	 * req用来读取请求数据；
	 * res用来设置响应数据；
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.(提供浏览器发送给服务器的)请求行
		System.out.println("请求方式:"+req.getMethod());
		System.out.println("Servlet路径:"+req.getServletPath());
		System.out.println("协议类型:"+req.getProtocol());
		//2.（提供浏览器发送给服务器的）消息头(key-value)
		//headerNames是所有key的迭代器
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(key + ":" + value);
		}
		//3.(提供浏览器发送给服务器的)实体内容
		//本次请求没有传业务数据，因此实体内容为空。
		
		//1.状态行
		//服务器输出响应信息时，自动填写该值。
		//2.(返回给浏览器的响应)消息头
		res.setContentType("text/html");
		//3.实体内容
		PrintWriter w = res.getWriter();
		w.println("<h1>HI</h1>");
		w.close();
	}
}

