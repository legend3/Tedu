package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;
import util.DBTool;
import util.DBUtil;


public class TestDay01 {
	
	/**
	 * 测试DBUtil
	 */
	@Test
	public void test5() {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			System.out.println(con);
			System.out.println(
				con.getClass().getName());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"创建连接失败", e);
		} finally {
			DBUtil.close(con);
		}
	}
	
	/**
	 * 插入员工
	 */
	@Test
	public void test4() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			//创建Statement
			Statement smt = con.createStatement();
			//写SQL
//			当数据表中有自增长主键时，当用SQL插入语句中插入语句带有ID列值记录的时候；
//			如果指定了该列的值，则新插入的值不能和已有的值重复，而且必须大于其中最大的一个值；
//			也可以不指定该列的值，只将其他列的值插入，让ID还是按照MySQL自增自己填；
//			这种情况在进行插入的时候，两种解决方法：
//				可以把id的值设置为null或者0，这样子mysql都会自己做处理
//				手动指定需要插入的列，不插入这一个字段的数据！

			String sql = 
				"insert into emp "
				+ "values(null,"
				+ "'唐僧','领导',0,sysdate(),"
				+ "9000.0,5000.0,2)";
			//执行DML
			//返回此SQL所影响的行数
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"插入员工失败", e);
		} finally {
			DBTool.close(con);
		}
	}
	
	/**
	 * 测试DBTool
	 */
	@Test
	public void test3() {
		Connection con = null;
		try {
			con = DBTool.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTool.close(con);
		}
	}
	
	/**
	 * 读取db.properties
	 * 
	 * java.util.Properties
	 * 专门用来读取properties文件的；
	 * 它就是一个散列表(哈希/Map)；
	 * 散列表的特点是查找速度快；
	 */
	@Test
	public void test2() {
		Properties p = new Properties();
		try {
			//任何类的ClassLoader都可以用来加载
			//项目内的properties文件。
			p.load(TestDay01.class.getClassLoader()
				.getResourceAsStream("db.properties"));
			//通过对象p获取该文件中的参数
			String driver = p.getProperty("driver");
			System.out.println(driver);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载文件失败", e);
		}
	}

	/**
	 * 创建连接
	 */
	@Test
	public void test1() {
		Connection con = null;
		try {
			//加载驱动
			Class.forName(
//					"oracle.jdbc.driver.OracleDriver"
					"com.mysql.cj.jdbc.Driver");
			//创建连接
			con = DriverManager.getConnection(
//				"jdbc:oracle:thin:@192.168.201.202:1521:orcl", "openlab", "open123");
					"jdbc:mysql://root@localhost:3306/netctoss?allowMultiQueries=true&useSSL=false&encoding=utf8",
					"root","root");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			//异常处理：
			//1.记录日志
			e.printStackTrace();
			//2.尽量处理(如返回默认值)
			//3.抛出由调用方处理
			throw new RuntimeException(
				"加载驱动失败", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"创建连接失败", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭连接失败", e);
				}
			}
		}
	}
	
}












