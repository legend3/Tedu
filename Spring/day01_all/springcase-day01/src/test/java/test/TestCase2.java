package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc2.A;

/**
 * 测试类
 *
 */
public class TestCase2 {
	//@Test
	//测试set方式注入。
	//public void test1(){
	//	ApplicationContext ac = 
	//new ClassPathXmlApplicationContext(
		//	"app3.xml");
		//A a = ac.getBean("a",A.class);
		//a.service();
	//}
	
	@Test
	//测试构造器方式注入。
	public void test2(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app4.xml");
		A a = ac.getBean("a",A.class);
		a.service();
	}
	
	
	
	
	
}
