package cn.yd.oa.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.yd.oa.model.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate=null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	//
	public ArrayList<Product> queryByName(String name) {
		return null;
	}
	
	
	//����һ��id����ѯ����
	public Product getById(int id) {
		return null;
	}
	
	
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId()});
	}
	
	public void delete(Integer id) {
		String sql = "delete from product where id=?";
		jdbcTemplate.update(sql, new Object[] {id});
	}
	
	public void save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		jdbcTemplate.update(sql, new Object[] {product.getName(),product.getPrice(),product.getRemark()});
	}

}
