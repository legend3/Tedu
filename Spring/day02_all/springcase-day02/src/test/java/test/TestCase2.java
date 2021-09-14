package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Restaurant;
import annotation.Student;

public class TestCase2 {
	@Test
	//测试组件扫描
	public void test1(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app3.xml");
	Student stu = ac.getBean("stu",
			Student.class);
	System.out.println(stu);
	
	}
	
	@Test
	//测试作用域
	public void test2(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app3.xml");
	Student stu = ac.getBean("stu",
			Student.class);
	Student stu2 = ac.getBean("stu",
			Student.class);
	System.out.println(stu == stu2);
	
	}
	
	@Test
	//测试延迟加载
	public void test3(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app3.xml");
	
	
	}
	
	@Test
	//测试生命周期相关的两个方法
	public void test4(){
		AbstractApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app3.xml");
		Student stu = 
				ac.getBean("stu",Student.class);
		System.out.println(stu);
		ac.close();
	}
	
	@Test
	//测试@Autowired和@Qualifier
	public void test5(){
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app3.xml");
		Restaurant rest = 
				ac.getBean("rest",
						Restaurant.class);
		System.out.println(rest);
	}
	
	
	
	
	
	
}
