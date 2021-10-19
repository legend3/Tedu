package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {

	//当服务器关闭时会销毁Filter，
	//它会自动调用此销毁方法。
	public void destroy() {
		System.out.println("销毁FirstFilter");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		System.out.println(req);
		System.out.println(res);
		
		System.out.println("aaa");
		//让请求向下继续执行。
		//若没调用此方法，则请求中断。
		chain.doFilter(req, res);
		System.out.println("bbb");
	}

	//当服务器启动时会初始化Filter，
	//它会自动调用此初始化方法。
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化FirstFilter");
	}

}
