package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.接收请求数据：本案例没有要接收的数据
		//2.处理业务：查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3.发送响应数据：拼一个table
		res.setContentType("text/html;charset=utf-8");
		/*
		*
		* 首选理解前端项目的实质：前端项目是依赖于浏览器而生存，就是浏览器中的页面而已，前端项目支持window.location.href="xxxx"或者ajax调用等那是因为浏览器支持它们，所以前端项目才这样写。
			当浏览器是window.location.href="xxxx"方式调用时可以在接口中用response.getWriter().write（xxxx）返回给浏览器结果，和return 配合@Responsebody 一样的效果（加上 @Responsebody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中）。
			但是如果浏览器是ajax请求的话，就不能使用response.getWriter().write（xxxx），因为ajax请求期望return回值以便做后续处理,如果使用了response.getWriter().write（xxxx）响应给了浏览器，浏览器就傻了。
		* */
		PrintWriter w = res.getWriter();

		
		//当前：/EmpManager/findEmp
		//目标：/EmpManager/add_emp.html
		w.println("<input type='button' value='增加' onclick='location.href=\"add_emp.html\"'/>");
		w.println("<table border='1' cellspacing='0' width='40%'>");
		w.println("  <tr>");
		w.println("		<th>编号</th>");
		w.println("		<th>姓名</th>");
		w.println("		<th>职位</th>");
		w.println("		<th>工资</th>");
		w.println("  </tr>");
		for(Emp e : list) {
			w.println("<tr>");
			w.println("	<td>"+e.getEmpno()+"</td>");
			w.println("	<td>"+e.getEname()+"</td>");
			w.println("	<td>"+e.getJob()+"</td>");
			w.println("	<td>"+e.getSal()+"</td>");
			w.println("</tr>");
		}
		w.println("</table>");
		w.close();
	}
}
