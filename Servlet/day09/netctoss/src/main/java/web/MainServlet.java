package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.CostDao;
import entity.Admin;
import entity.Cost;
import util.ImageUtil;

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
		} else if("/addCost.do".equals(path)) {
			//增加保存资费
			addCost(req, res);
		} else if("/toUpdateCost.do".equals(path)) {
			//打开修改资费页面
			toUpdateCost(req, res);
		} else if("/toLogin.do".equals(path)) {
			//打开登录页
			toLogin(req, res);
		} else if("/toIndex.do".equals(path)) {
			//打开首页
			toIndex(req, res);
		} else if("/login.do".equals(path)) {
			//登录检查
			login(req, res);
		} else if("/logout.do".equals(path)) {
			//退出登录
			logout(req, res);
		} else if("/createImg.do".equals(path)) {
			//生成验证码
			createImg(req, res);
		} else {
			throw new RuntimeException("没有这个页面");
		}
	}
	
	private void createImg(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		//生成验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		String imgcode = (String) objs[0];
		req.getSession().setAttribute("imgcode", imgcode);
		//将图片输出给浏览器
		BufferedImage img = (BufferedImage) objs[1];
		//告诉浏览器输出的内容类型
		res.setContentType("image/png");
		//通过response获取的输出流，
		//其输出的目标就是当前请求的浏览器。
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		//销毁session
		req.getSession().invalidate();
		//重定向到登录
		res.sendRedirect(req.getContextPath()+"/toLogin.do");
	}
	
	private void login(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//接收表单数据
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		//从session中获取生成的验证码
		HttpSession session = req.getSession();
		String imgcode = (String) session.getAttribute("imgcode");
		//比较验证码
		if(code == null
			|| !code.equalsIgnoreCase(imgcode)) {
			//验证码错误
			req.setAttribute("error", "验证码错误");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			return;
		}
		//检查该数据
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		if(a == null) {
			//账号不存在
			req.setAttribute("error", "账号不存在");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		} else if(!a.getPassword().equals(password)) {
			//密码错误
			req.setAttribute("error", "密码错误");
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		} else {
			//将账号存入cookie
			Cookie c = new Cookie("adminCode", adminCode);
			res.addCookie(c);
			//将账号存入session
			session.setAttribute("adminCode", adminCode);
			//登录成功
			res.sendRedirect("toIndex.do");
		}
	}
	
	private void toLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//转发到：WEB-INF/main/login.jsp
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}
	
	private void toIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//转发到：WEB-INF/main/index.jsp
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, res);
	}
	
	private void toUpdateCost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		//接收参数
		String id = req.getParameter("id");
		//查询出要修改的资费
		CostDao dao = new CostDao();
		Cost cost = dao.findById(new Integer(id));
		//转发到修改页
		req.setAttribute("cost", cost);
		req.getRequestDispatcher("WEB-INF/cost/update.jsp").forward(req, res);
	}
	
	private void addCost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		//接收表单数据
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter("unitCost");
		String descr = req.getParameter("descr");
		//保存这些数据
		Cost cost = new Cost();
		cost.setName(name);
		cost.setCostType(costType);
		cost.setDescr(descr);
		if(baseDuration != null && !baseDuration.equals("")) {
			cost.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost != null && !baseCost.equals("")) {cost.setBaseCost(
				new Double(baseCost));
		}
		if(unitCost != null && !unitCost.equals("")) {
			cost.setUnitCost(new Double(unitCost));
		}
		CostDao dao = new CostDao();
		dao.save(cost);
		//重定向到查询
		//当前：/netctoss/addCost.do
		//查询：/netctoss/findCost.do
		res.sendRedirect("findCost.do");
	}
	
	private void toAddCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//当前：/netctoss/toAddCost.do
		//目标：/netctoss/WEB-INF/cost/add.jsp
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}

	private void findCost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
