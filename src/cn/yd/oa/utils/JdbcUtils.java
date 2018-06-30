package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public static void main(String[] args) {
		JdbcUtils utils = new JdbcUtils();
		utils.getConnection();
	}
	
	public Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:16608/mysql","root", "");
			//System.out.println(connection);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e); 
		}
	}

	static {
		System.out.println("静态块，此类加载到JVM中时会自动执行一次");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//一般在开发时用打印。
			//e.printStackTrace();
			//在项目中一般要将异常抛出到上一级调用的程序
			throw new RuntimeException(e); 
		}
	}
	
}
