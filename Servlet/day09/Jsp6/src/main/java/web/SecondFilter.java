package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	public void destroy() {
		System.out.println("销毁SecondFilter");
	}

	public void doFilter(
		ServletRequest req, 
		ServletResponse res, 
		FilterChain chain)
		throws IOException, ServletException {
		System.out.println("ccc");
		chain.doFilter(req, res);
		System.out.println("ddd");
	}

	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("初始化SecondFilter");
		System.out.println(
			cfg.getInitParameter("city"));
	}

}
