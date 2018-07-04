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

public interface ProductDao {
	
	public void save(Product product);
	public void update(Product product);
	public void delete(int id);
	public ArrayList<Product> queryByName(String name);
	public Product getById(int id);
}
