package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;

public class TestCase {
	private SqlSession session;
	
	@Before
	//初始化方法。junit会在测试方法运行之前,
	//先运行初始化方法。
	public void init(){
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
			//创建SqlSessionFactory对象。
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
		//System.out.println(session);
		Emp emp = new Emp();
		emp.setName("King");
		emp.setAge(20);
		/*
		 * insert方法:插入记录。
		 * 第一个参数是要执行的sql的id(id是在
		 * 映射文件当中设置的),第二个参数是要
		 * 插入的对象。
		 */
		session.insert("save", emp);
		//要提交事务
		session.commit();
		//关闭(会关闭connection)
		session.close();
	}
	
	
	@Test
	//测试查询（查询所有记录）
	public void test2(){
		List<Emp> emps = 
				session.selectList(
						"findAll");
		System.out.println(emps);
		session.close();
	}
	
	@Test
	//测试查询（查询一条记录）
	public void test3(){
		Emp emp = 
				session.selectOne(
						"findById", 21);
		System.out.println(emp);
		session.close();
	}
	
	@Test
	//修改记录
	public void test4(){
		Emp emp = 
				session.selectOne(
						"findById", 21);
		emp.setAge(emp.getAge() * 3);
		session.update("update", emp);
		session.commit();
		session.close();
	}
	
	@Test
	//测试删除
	public void test5(){
		session.delete("delete", 21);
		session.commit();
		session.close();
	}
	
	@Test
	//测试 查询结果为map
	public void test6(){
		Map map = 
				session.selectOne(
						"findById2", 23);
		//oracle数据库默认会将字段名变成大写形式。
		System.out.println(map.get("NAME"));
		session.close();
	}
	
	
}
