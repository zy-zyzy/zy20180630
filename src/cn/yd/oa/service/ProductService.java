package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

//此类主要是用来实现业务逻辑的
public class ProductService {

	ProductDao productDao = new ProductDao();
	public void save(Product product) {
		productDao.save(product);
	}
	
	public ArrayList<Product> queryByName(String name) {
		return productDao.queryByName(name);
		
	}
	
	public void delete(int id) {
		productDao.delete(id);
		
	}
}
