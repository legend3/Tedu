package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;
import entity.Emp2;

public class TestCase {
	private ApplicationContext ac = null;
	@Before
	//@Before修饰的方法会在测试方法执行前先执行。
	public void init(){
		//启动spring容器。
		ac = new ClassPathXmlApplicationContext(
				"app.xml");
		
	}
	
	@Test
	public void test1(){
		//通过容器得到一个DAO对象。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = new Emp();
		emp.setName("Hello kitty");
		emp.setAge(29);
		dao.save(emp);
	}
	
	@Test
	public void test2(){
		//通过容器得到一个DAO对象。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		List<Emp> emps = 
				dao.findAll();
		System.out.println(emps);
	}
	
	@Test
	public void test3(){
		//通过容器得到一个DAO对象。
		//bean的id是Mapper接口首字母小写。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = dao.findById(42);
		System.out.println(emp);
	}
	
	@Test
	public void test4(){
		//通过容器得到一个DAO对象。
		//bean的id是Mapper接口首字母小写。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = dao.findById(42);
		emp.setAge(emp.getAge() * 2);
		dao.update(emp);
	}
	
	@Test
	public void test5(){
		//通过容器得到一个DAO对象。
		//bean的id是Mapper接口首字母小写。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		dao.delete(42);
	}
	
	@Test
	public void test6(){
		//通过容器得到一个DAO对象。
		//bean的id是Mapper接口首字母小写。
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp2 emp2 = 
				dao.findById3(23);
		System.out.println(emp2);
	}
	
	
}
