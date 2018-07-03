package cn.yd.oa.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.yd.oa.model.Product;

public class ProductDao {
	private JdbcTemplate jdbcTemplate=null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	//
	public ArrayList<Product> queryByName(String name) {
		String sql="select * from product where name like ?";
		return (ArrayList<Product>) jdbcTemplate.query(sql, new Object[] {"%"+name+"%"}, new BeanPropertyRowMapper(Product.class));
	}
	
	
	//根据一个id来查询对象
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		//BeanPropertyRowMapper：spring提供的属性映射工具类（只要字段与属性相同则数据自动匹配）
		//queryforobject是返回一个，query是返回多个
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Product>(Product.class));
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
