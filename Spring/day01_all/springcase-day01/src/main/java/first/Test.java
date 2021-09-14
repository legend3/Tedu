package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示如何启动spring容器。
 *
 */
public class Test {
	
	public static void main(String[] args) {
		//配置文件名称可以改，位置也可以改变。
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		System.out.println(ac);
		
		//getBean方法:通知容器，依据id，获取
		//对应的bean实例。
		HelloBean hb = 
				ac.getBean("hb",HelloBean.class);
		System.out.println(hb);
		
		Date date1 = 
				ac.getBean("date1",Date.class);
		System.out.println(date1);
		
		Calendar cal1 = 
				ac.getBean("cal1",
						Calendar.class);
		System.out.println(cal1);
		
		Date date2 = 
				ac.getBean("time1",
						Date.class);
		System.out.println(date2);
	}

}
