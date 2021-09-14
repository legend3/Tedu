package test;


import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
	@Test
	//测试DataSource
	public void test1() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		DataSource ds = 
				ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	
	@Test
	//测试EmpDAO
	public void test2() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = new Emp();
		emp.setName("Sally");
		emp.setAge(22);
		dao.save(emp);
	}
	
	@Test
	//测试EmpDAO
	public void test3() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		List<Emp> emps = 
				dao.findAll();
		System.out.println(emps);
	}
	
	@Test
	//测试EmpDAO
	public void test4() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = dao.findById(1);
		System.out.println(emp);
	}
	
	@Test
	//测试EmpDAO
	public void test5() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		Emp emp = dao.findById(1);
		emp.setAge(emp.getAge() * 2);
		dao.update(emp);
	}
	
	@Test
	//测试EmpDAO
	public void test6() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		dao.delete(1);
	}
	
	@Test
	//测试EmpDAO
	public void test7() throws SQLException{
		ApplicationContext ac = 
	new ClassPathXmlApplicationContext(
			"app.xml");
		EmpDAO dao = 
				ac.getBean("empDAO",
						EmpDAO.class);
		System.out.println(dao.getTotal());
	}
	
	
}
