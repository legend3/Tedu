package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;
import entity.Emp2;

public class TestCase2 {
private SqlSession session;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = 
				ssfb.build(
					TestCase.class
					.getClassLoader()
					.getResourceAsStream(
							"SqlMapConfig.xml"));
			session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		//getMapper方法会按照
		//Mapper接口要求，返回一个实现了
		//该接口要求的对象。
		EmpDAO dao = 
				session.getMapper(
						EmpDAO.class);
		System.out.println(dao.getClass().getName());
		Emp emp = new Emp();
		emp.setName("Eric");
		emp.setAge(22);
		dao.save(emp);
		//对于添加、修改、删除仍然需要提交事务。
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		EmpDAO dao = session.getMapper(EmpDAO.class);
		List<Emp> emps = 
				dao.findAll();
		System.out.println(emps);
		session.close();
	}
	
	@Test
	public void test3(){
		EmpDAO dao = 
				session.getMapper(EmpDAO.class);
		Emp2 emp2 = dao.findById3(22);
		System.out.println(emp2);
		session.close();
	}
	
	
	
}
