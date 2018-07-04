package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

//此类主要是用来实现业务逻辑的
public class ProductService {
	
	ProductDao productDao = null;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public void save(Product product) {
		productDao.save(product);
		//如果有代码失败，应该回滚。
		//Integer.parseInt("dfgdg");
	}
	
	public ArrayList<Product> queryByName(String name) {
		return productDao.queryByName("%"+name+"%");
		
	}
	
	public void delete(int id) {
		productDao.delete(id);
		
	}
	
	public Product getById(int id) {
		return productDao.getById(id);
		
	}
	
	public void update(Product product) {
		productDao.update(product);
		
	}
}
