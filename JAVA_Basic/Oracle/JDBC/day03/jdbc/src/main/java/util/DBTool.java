package util ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	
	//数据库连接参数
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	//这些参数只读一次即可
	static {
		Properties p = new Properties();
		try {
			p.load(DBTool.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			//只需要加载一次驱动即可
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载资源文件失败", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"加载驱动失败", e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}
	
	public static void close(Connection con) {
		if(con  != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭连接失败", e);
			}
		}
	}
}
