package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器：是springmvc提供的一个组件，前端控制器会先调用拦截器 ，然后再调用处理器。
 * 如何写一个拦截器?
 * step1, 写一个java类，实现HandlerInterceptor接口。
 * step2, 将拦截处理逻辑写在对应的方法里。
 * 		preHandle方法: 前端控制器先调用拦截器的preHandle方法， 再调用处理器的处理方法。如果该方法的返回值为true,表示 继续向后调用。
 * 		postHandle方法:处理器的方法已经执行完毕，在将ModelAndView 返回给前端控制器之前执行该方法。所以，可以在该方法里面修改 ModelAndView。
 * 		afterCompletion方法：最后执行的方法。
 * step3,配置拦截器(spring配置文件)。
 *
 */
public class SomeInterceptor implements HandlerInterceptor{

	/**
	 * 最后执行的方法。
	 * ex:处理器抛出的异常对象。
	 */
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception ex) throws Exception {
		System.out.println("SomeInterceptor's afterCompletion()");
	}

	/**
	 * 处理器的方法已经执行完毕，在将ModelAndView
	返回给前端控制器之前执行该方法。所以，可以在
	该方法里面修改ModelAndView。
	 */
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView mav) throws Exception {
		System.out.println("SomeInterceptor's postHandle()");
	}

	/**
	 * 前端控制器先调用拦截器的preHandle方法，
	再调用处理器的处理方法。
		arg2:处理器方法对象。
		如果返回值为true,表示继续向后调用；
		如果返回值为false,不会继续向后调用，
		请求处理完毕。
	 */
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		System.out.println("SomeInterceptor's preHandle()");
		return true;
	}
	

}
