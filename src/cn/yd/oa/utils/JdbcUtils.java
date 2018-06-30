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
		System.out.println("��̬�飬������ص�JVM��ʱ���Զ�ִ��һ��");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//һ���ڿ���ʱ�ô�ӡ��
			//e.printStackTrace();
			//����Ŀ��һ��Ҫ���쳣�׳�����һ�����õĳ���
			throw new RuntimeException(e); 
		}
	}
	
}
