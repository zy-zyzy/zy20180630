package cn.yd.oa.service;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

//此类主要是用来实现业务逻辑的
public class ProductService {

	ProductDao productDao = new ProductDao();
	public void save(Product product) {
		productDao.save(product);
	}
}
