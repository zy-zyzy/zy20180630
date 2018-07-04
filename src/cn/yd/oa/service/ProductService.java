package cn.yd.oa.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

//������Ҫ������ʵ��ҵ���߼���
@Component(value="ps")
public class ProductService {
	ProductDao productDao = null;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public void save(Product product) {
		productDao.save(product);
		//����д���ʧ�ܣ�Ӧ�ûع���
		//Integer.parseInt("dfgdg");
	}
	
	public ArrayList<Product> queryByName(String name) {
		return productDao.queryByName(name);
		
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
