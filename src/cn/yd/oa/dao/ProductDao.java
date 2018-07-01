package cn.yd.oa.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

public class ProductDao extends BaseDao {
	//
	public ArrayList<Product> queryByName(String name) {
		ArrayList<Product> productlist = new ArrayList<Product>();
		String  sql = "select * from product where name like ?";
		//1、连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();
		//2、编译和执行SQL
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+name+"%");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				productlist.add(product);
			}
			//3、返回查询的结果集
			return productlist;
			
			//4、释放资源
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
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
	
	
	//根据一个id来查询对象
	public Product getById(int id) {
		Product product =null;
		String  sql = "select * from product where id = ?";
		//1、连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection connection = utils.getConnection();
		//2、编译和执行SQL
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				
				
			}
			//3、返回查询的结果集
			return product;
			
			//4、释放资源
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
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
	
	
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
	}
	
	public void delete(Integer id) {
		String sql = "delete from product where id=?";
		super.executeUpdate(sql, new Object[] {id});
	}
	
	public void save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark()});
	}

}
