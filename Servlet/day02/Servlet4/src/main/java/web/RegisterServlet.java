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
		
		//处理中文乱码
		//byte[] bs = name.getBytes("iso8859-1");
		//name = new String(bs,"utf-8");
		
		//2.处理业务(对浏览器发往服务器的请求参数经行处理)
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
