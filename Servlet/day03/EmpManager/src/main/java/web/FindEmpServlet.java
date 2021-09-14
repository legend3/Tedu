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







