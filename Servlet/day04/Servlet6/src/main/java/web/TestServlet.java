package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	/*
	 * 成员变量-堆
	 *
	 * (方法中)局域变量-栈
	 * */
	private double salary = 3000;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		synchronized (this) {
			//模拟加薪
			salary += 100;
			//模拟网络延迟
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//输出响应信息
			res.setContentType("text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("工资:" + salary);
			w.close();
		}
	}
}
