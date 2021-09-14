package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//创建当前系统时间
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat("HH:mm:ss");
		String now = sdf.format(date);
		//向浏览器输出一个HTML，内含当前系统时间
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		//此处省略了很多标签
		w.println("<h1>"+now+"</h1>");
		w.close();
		System.out.println(1);
	}
}















