package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			//查询资费
			findCost(req, res);
		} else if("/toAddCost.do".equals(path)) {
			//打开增加资费
			toAddCost(req, res);
		} else {
			throw new RuntimeException("没有这个页面");
		}
	}
	
	private void toAddCost(
		HttpServletRequest req,
		HttpServletResponse res)
		throws ServletException, IOException{
		//当前：/netctoss/toAddCost.do
		//目标：/netctoss/WEB-INF/cost/add.jsp
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}

	private void findCost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		//查询所有的资费
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//转发到查询页面
		req.setAttribute("costs", list);
		//当前:/netctoss/findCost.do
		//目标:/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, res);
	}
}












