package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.utils.JdbcUtils;

public class BaseDao {

	public void executeUpdate(String sql,Object[] param) {
		// 1���������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();

		// 2��Java����SQL��䣬����ֵ����

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			// preparedStatement.setString(1, product.getName());
			// preparedStatement.setDouble(2, product.getPrice());
			// preparedStatement.setString(3, product.getRemark());
			for(int i=0;i<param.length;i++) {
				preparedStatement.setObject(i+1, param[i]);
			}
			int count = preparedStatement.executeUpdate();
			System.out.println("count��" + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3���ر�Connection�ͷ���Դ
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

}
