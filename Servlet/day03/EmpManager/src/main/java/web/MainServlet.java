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

/**
 * 路径规范：
 * 	查询员工：/findEmp.do
 *  增加员工：/addEmp.do
 * 
 * 思路：所有普通的请求都以.do为后缀。
 * 	将来若有特殊请求，再追加其他的后缀。
 * 	如：播放视频view.video，发邮件send.email
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//根据规范判断请求路径
		String path = req.getServletPath();
		if("/findEmp.do".equals(path)) {
			findEmp(req, res);
		} else if("/addEmp.do".equals(path)) {
			addEmp(req, res);
		} else {
			throw new RuntimeException("没有这个页面。");
		}
	}

	protected void findEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.接收请求数据：本案例没有要接收的数据
		//2.处理业务：查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//3.发送响应数据：拼一个table
		res.setContentType(
			"text/html;charset=utf-8");
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
	
	protected void addEmp(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接收请求数据
		String name = req.getParameter("name");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//处理业务
		EmpDao dao = new EmpDao();
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		e.setSal(new Double(sal));
		dao.save(e);
		//输出响应信息
//			res.setContentType(
//				"text/html;charset=utf-8");
//			PrintWriter w = res.getWriter();
//			w.println("<p>保存成功</p>");
//			w.close();
		//重定向到查询员工
		//当前：/EmpManager/addEmp.do
		//目标：/EmpManager/findEmp.do
		res.sendRedirect("findEmp.do");
	}
	
}








