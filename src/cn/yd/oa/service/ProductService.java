package cn.yd.oa.service;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

//������Ҫ������ʵ��ҵ���߼���
public class ProductService {

	ProductDao productDao = new ProductDao();
	public void save(Product product) {
		productDao.save(product);
	}
}
