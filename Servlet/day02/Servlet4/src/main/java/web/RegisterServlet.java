package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//设置发往服务器的参数的编码格式
		//1.接收请求数据
		//方法的参数必须与表单控件的name一致
		String name = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests = req.getParameterValues("interest");
		
		//处理中文乱码(String(按照指定编码格式)转字符数组)
		byte[] bs = name.getBytes("iso8859-1");//String的getBytes()方法是得到一个操作系统默认的编码格式的字节数组。
												//这表示在不同的操作系统下,返回的东西不一样!
													//String.getBytes(Stringdecode)方法会根据指定的decode编码返回某字符串在该编码下的byte数组表示
		name = new String(bs,"UTF-8");
		
		//2.处理业务(对浏览器发往服务器的请求参数进行处理)
		//此处省略保存业务，仅以输出代替
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String itr : interests) {
				System.out.println(itr);
			}
		}
		//3.输出响应数据
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		w.println("<h1>Success</h1>");
		w.close();
	}
}
