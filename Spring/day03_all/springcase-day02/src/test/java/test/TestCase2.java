package test;

import annotation.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase2 {
	@Test
	//测试组件扫描
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Student stu = ac.getBean("stu", Student.class);
		System.out.println(stu);
	}

	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}

	@Test
	public void test01(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		School school = ac.getBean("school", School.class);
		System.out.println(school.getName() + "\n" + school.getPageSize() + "\n" + school.getWt());
	}

	@Test
	//测试作用域：默认singlton
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Student stu = ac.getBean("stu", Student.class);
		Student stu2 = ac.getBean("stu", Student.class);
		System.out.println(stu == stu2);
	
	}
	
	@Test
	//测试延迟加载：带有@lazy注释的Bean将在被第一次实例化时才被实现
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
	}
	
	@Test
	//测试生命周期相关的两个方法
	public void test4(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Student stu = ac.getBean("stu",Student.class);
		System.out.println(stu);
		ac.close();
	}
	
	@Test
	//测试@Autowired和@Qualifier
	public void test5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Restaurant rest = ac.getBean("rest", Restaurant.class);
		System.out.println(rest);
	}
	
	@Test
	//测试@Autowired和@Qualifier
	public void test6(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		Bar bar = ac.getBean("bar",Bar.class);
		System.out.println(bar);
	}
	
	@Test
	//测试@Resource
	public void test7(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("app3.xml");
		School s = ac.getBean("school", School.class);
		System.out.println(s);
	}
	
	
	
}
