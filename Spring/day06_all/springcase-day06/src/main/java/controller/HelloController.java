package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello1(){
		System.out.println("HelloController's hello()");
		return "hello";
	}
	
	@RequestMapping("/abc/hello2.do")
	public String hello2(){
		System.out.println("HelloController's hello2()");
		return "hello";
	}
	
	@RequestMapping("/hello3.do")
	public String hello3(){
		System.out.println("HelloController's hello3()");
		Integer.parseInt("123a");
		
		return "hello";
	}
	
	
	@RequestMapping("/hello4.do")
	//java.lang.StringIndexOutOfBoundsException
	public String hello4(){
		System.out.println("HelloController's hello4()");
		String str = "abcdefg";
		str.charAt(20);
		return "hello";
	}
	
	
	@ExceptionHandler
	/*
	 * 这是一个异常处理方法，用来处理其它
	 * 方法所抛出的异常。
	 * ex:其它方法所抛出的异常。
	 */
	public String execute(HttpServletRequest request, Exception ex){
		//依据异常类型，分别做不同的处理。
		if(ex instanceof NumberFormatException){
			request.setAttribute("msg", "请输入数字");
			return "error2";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("msg", "数组越界");
			return "error2";
		}
		return "error3";
	}
}
