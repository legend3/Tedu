package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import net.sf.json.JSONArray;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取请求资源路径。 
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		String action = uri.substring(
						uri.lastIndexOf("/"),
						uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if("/check_uname".equals(action)){
			//检查用户名是否存在
			String username = request.getParameter("username");
			System.out.println("username:" + username);
			//假设数据库里面有一个用户Tom
			if("李白".equals(username)){
				out.println("用户名被占用了");
			}else{
				out.println("可以使用");
			}
		}else if("/quoto".equals(action)){
			//模拟生成几只股票的数据，
			//这些数据要转换成json字符串之后 
			//发送给浏览器。
			Random r = new Random();
			List<Stock> stocks = 
					new ArrayList<Stock>();
			for(int i = 0; i < 8; i ++){
				Stock s = new Stock();
				s.setCode("00000" + r.nextInt(10));
				s.setName("万科A"+ r.nextInt(10));
				s.setPrice(r.nextInt(100));
				stocks.add(s);
			}
			JSONArray  arr = JSONArray.fromObject(stocks);
			String jsonStr = arr.toString();
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if("/getFlights".equals(action)){
			String flight = request.getParameter("flight");
			System.out.println("flight:" + flight);
			if("CA1204".equals(flight)){
				out.println("头等舱:￥2400<br/>"
						+ "商务舱:￥2200");
			}else{
				out.println("头等舱:￥1600<br/>"
						+ "商务舱:￥1400");
			}
		}
		
	}
}




