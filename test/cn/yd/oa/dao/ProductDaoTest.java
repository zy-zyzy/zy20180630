package cn.yd.oa.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yd.oa.model.Product;

public class ProductDaoTest {
	private static  ProductDao productDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前执行，通常用来初始化测试对象");
		productDao = new ProductDao();	
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("此方法在测试方法之后执行，通常用来释放资源");
		productDao = null;
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("华为手机");
		product.setPrice(2800.00);
		product.setRemark("华为P10");
		product.setId(2);
		productDao.update(product);
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setId(2);
		productDao.delete(product.getId());
	}

	@Test
	public void testSave() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("华为手机");
		product.setPrice(2800.00);
		product.setRemark("华为P10");
		product.setId(2);
		productDao.save(product);
	}
	
	@Test
	public void testGetById() {
		//fail("Not yet implemented");
		Product product = productDao.getById(3);
		System.out.println(product.toString());
	}
	
	@Test
	public void testQueryByName() {
		//fail("Not yet implemented");
		ArrayList<Product> product = productDao.queryByName("");
		for(Product product2 :product) {
			System.out.println(product2.toString());
		}
		
	}

}
