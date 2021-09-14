package web;

import java.io.IOException;
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
		//查询所有的员工
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		System.out.println(list);
		//将请求转发给JSP
		//1.将数据绑定在request上，以提交给JSP。
		req.setAttribute("emps", list);
		//2.转发给JSP
		//当前：/Jsp2/findEmp
		//目标：/Jsp2/emp_list.jsp	(把绑定的数据转发给emp_list.jsp再进行处理、展现)
		req.getRequestDispatcher("emp_list.jsp").forward(req, res);
	}
}
