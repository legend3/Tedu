package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		e.setSal(new Double(sal));//str转double
		dao.save(e);
		//输出响应信息
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter w = res.getWriter();
//		w.println("<p>保存成功</p>");
//		w.close();

		/*
			重定向到查询员工
			当前：/EmpManager/addEmp
			目标：/EmpManager/findEmp
		*/
		res.sendRedirect("findEmp");
	}
}






