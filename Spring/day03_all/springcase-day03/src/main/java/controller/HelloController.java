package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 处理器：处理业务逻辑。
 *
 */
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController的handleRequest方法...");
		/*
		 * ModelAndView有两个构造器。
		 * 1. ModelAndView(String viewName)
		 * viewName是视图名。
		 * 2. ModelAndView(String viewName,Map data)
		 * data是数据。
		 */
		return new ModelAndView("hello");
	}

}
