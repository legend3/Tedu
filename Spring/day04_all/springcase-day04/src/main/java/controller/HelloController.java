package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 处理器(业务逻辑的处理)。
a. 不用实现Controller接口。
b. 可以添加多个处理方法。
c. 处理方法的名称可以自定义，方法的返回值可以是ModelAndView,也可以是String。
d. 在类名前，添加 @Controller注解。
e. 可以在类名前或者处理方法前面添加 @RequestMapping注解。该注解的作用相当于HandleMapping(指示调用对应的controller方法)。
*/
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("HelloController的hello方法...");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("HelloController的toLogin方法...");
		return "login";
	} 
	
	@RequestMapping("/login.do")
	/*
	 * 读取请求参数值的第一种方式：
	 * 在处理方法里面，添加request作为方法的入参即可。
	 * 前端控制器会将request对象作为参数传进来。
	 */
	public String login(HttpServletRequest request){
		System.out.println("HelloController的login方法...");
		String username = request.getParameter("username");//获取jsp元素name为username的值，作为请求参数
		String pwd = request.getParameter("pwd");
		System.out.println("username:" + username + " pwd:" + pwd);
		return "index";//未有向页面传值！
	}
	
	@RequestMapping("/login2.do")
	/*
	 * 读取请求参数值的第二种方式：
	 * 将处理方法的入参与请求参数名保持一致。
	 * 
	 * 注：
	 * 如果不一致，可以使用@RequestParam(请求参数名):
	 * value：参数名字，即入参的请求参数名字，如username表示请求的参数区中的名字为username的参数的值将传入；
	 * required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报404错误码；
	 * defaultValue：默认值，表示如果请求中没有同名参数时的默认值，默认值可以是SpEL表达式，如“#{systemProperties['java.vm.version']}”。
	 */
	public String login2(String username, @RequestParam(value="pwd", required=false) String pwd1){
		System.out.println("HelloController的" + "login2方法...");
		System.out.println("username:" + username + " pwd:" + pwd1);
		return "index";//usenname、user未赋值，因此未有向页面传值！
	}
	
	
	@RequestMapping("/login3.do")
	/*
	 * 读取请求参数值的第三种方式：
	 * 将请求参数封装成一个javabean。
	 */
	public String login3(User user){
		System.out.println("HelloController的login3方法...");
		user.setUsername("legend");//通过此javabean对象向页面传值
		user.setPwd("111111");
		System.out.println("username:" + user.getUsername() + " pwd:" + user.getPwd());
		return "index";
	}
	
	
	@RequestMapping("/login4.do")
	/*
	 * 向页面传值的第一种方式：
	 * 通过ModelAndView。
	 * 将处理方法的返回值类型设置为ModelAndView。
	 */
	public ModelAndView login4(User user){
		System.out.println("HelloController的login4方法...");
		user.setUsername("legend");
		user.setPwd("123456");
		System.out.println(user.getUsername() + ":" + user.getPwd());
		/*
		 * ModelAndView(String viewName,Map data);
		 * viewName:视图名。
		 * data:处理结果。
		 */
		//将处理结果封装成一个Map对象。
		Map<String,Object> data = new HashMap<String,Object>();
		//相当于执行了request.setAttribute
		data.put("username", user.getUsername());
		data.put("user", user);
		//通过ModelAndView将map键值对向页面传值了！
		ModelAndView mav = new ModelAndView("index",data);
		return mav;//返回ModelAndView类型
	}
	
	@RequestMapping("/login5.do")
	/*
	 * 向页面传值的第二种方式：
	 * 通过ModelMap对象。
	 * 要将ModelMap对象作为方法的入参。
	 */
	public String login5(User user, ModelMap mm){
		System.out.println("HelloController的login5方法...");
		user.setUsername("legend");
		user.setPwd("123456");
		System.out.println(user.getUsername() + " " + user.getPwd());
		//将处理结果添加到ModelMap，相当于request.setAttribute
		mm.addAttribute("username", user.getUsername());
		mm.addAttribute("user",	user);
		return "index";
	}
	
	@RequestMapping("/login6.do")
	/*
	 * 向页面传值的第三种方式：
	 * 使用request。
	 * 
	 * request.getParameter()方法:
	 * 1.获取通过http协议提交过来的数据.通过容器的实现来取得通过get或者post方式提交过来的数据
	 * 2.request.getParameter()方法传递的数据，会从web客户端传到web服务器端，代表HTTP请求数据，该方法返回String类型的数据
	 * request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段
	 * request.getAttribute()方法返回request范围内存在的对象
	 * request.setAttribute() 和 getAttribute() 方法传递的数据只会存在于Web容器内部
	 * HttpServletRequest 类有 setAttribute() 方法，而没有setParameter() 方法
	 * 一般通过表单和链接传递的参数使用getParameter
	 */
	public String login6(HttpServletRequest request, User user){
		System.out.println("login6方法...");
		user.setUsername("legend");//通过javabean设置jsp(表单)的值
		user.setPwd("666");
		String username = request.getParameter("username");//获取(表单/链接)请求值
		String pwd = request.getParameter("pwd");
		request.setAttribute("username", "hangzhoudong");//（向jsp表单）设置传值
//		request.setAttribute("pwd", pwd);
		request.setAttribute("user", user);
		System.out.println(username);
		System.out.println(pwd);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	/*
	 * 向页面传值的第四种方式：
	 * 使用session。
	 */
	public String login7(User user,HttpSession session){//session生命周期比request长，占内存久，杀鸡用牛刀
		System.out.println("login7方法...");
		user.setUsername("legend");
		user.setPwd("123456");
		System.out.println(user.getUsername());
		System.out.println(user.getPwd());
		session.setAttribute("user", user);//对应：${user.username}的user
		session.setAttribute("username", user.getUsername());//对应：${username}的username
		return "index";
	}
	
	
	@RequestMapping("/login8.do")
	/*
	 * 重定向的第一种方式：
	 * 如果处理方法的返回值是String,
	 * 则在重定向地址前添加"redirect:"作为前缀。
	 */
	public String login8(User user){
		System.out.println("login8方法...");
		System.out.println("跳转到页面里才进行传值:" + user.getUsername());
		return "redirect:toIndex.do";//redirect:重定向的目标地址
	}
	
	@RequestMapping("/login9.do")
	/*
	 * 重定向的第二种方式：
	 * 如果处理方法的返回值是ModelAndView。
	 */
	public ModelAndView login9(User user){
		RedirectView rv = new RedirectView("toIndex.do");
		ModelAndView mav = new ModelAndView(rv);
		return mav;
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(User user, HttpSession session){
		user.setUsername("legend");
		user.setPwd("123456");
		session.setAttribute("user", user);
		System.out.println("跳转页面进行传值完毕！");
		return "index";
	}
	
	@RequestMapping("/toBmi.do")
	public String toBmi(){
		return "bmi";
	}
	
	@RequestMapping("/bmi.do")
	public String bmi(BmiParam bp, ModelMap mm){
		System.out.println("bmi方法...");
		bp.setHeight(198);
		bp.setWeight(90);
		System.out.println(bp.getHeight() + " " + bp.getWeight());
		//计算bmi指数
		double bmi = bp.getWeight() / bp.getHeight() / bp.getHeight();
		//依据bmi指数，判断用户的身体状况。
		String status = "正常";
		if(bmi <= 20){
			status = "过瘦";
		}else if(bmi > 25){
			status = "过重";
		}
		//向页面传值
		mm.addAttribute("status", status);
		return "view";
	}
	
}





