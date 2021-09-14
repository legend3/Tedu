package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Restaurant;
import basic.ExampleBean;
import basic.SomeBean;

public class TestCase {
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app2.xml");
		ExampleBean eb = ac.getBean("eb2",ExampleBean.class);
		System.out.println(eb);
	}
	
	@Test
	public void test3(){
		ApplicationContext ac =
		new ClassPathXmlApplicationContext("app2.xml");
		System.out.println(ac.getBean("config"));
	}
	
	@Test
	//测试spring表达式
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app2.xml");
		SomeBean sb = ac.getBean("sb",SomeBean.class);
		System.out.println(sb);
	}
	
}
