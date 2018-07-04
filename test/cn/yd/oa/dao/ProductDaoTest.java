package cn.yd.oa.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

public class ProductDaoTest {
	private static  ProductService productService;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前执行，通常用来初始化测试对象");
		//productDao = new ProductDao();	
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = context.getBean("ps",ProductService.class);
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("此方法在测试方法之后执行，通常用来释放资源");
		productService = null;
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("华为手机");
		product.setPrice(2800.00);
		product.setRemark("华为P10");
		product.setId(2);
		//productService.update(product);
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setId(2);
		productService.delete(product.getId());
	}

	@Test
	public void testSave() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("华为手机");
		product.setPrice(2800.00);
		product.setRemark("华为P10");
		product.setId(2);
//		productService.save(product);
	}
	
	@Test
	public void testGetById() {
		//fail("Not yet implemented");
		//Product product = productService.getById(3);
		//System.out.println(product.toString());
	}
	
	@Test
	public void testQueryByName() {
		//fail("Not yet implemented");
		ArrayList<Product> product = productService.queryByName("");
		for(Product product2 :product) {
			System.out.println(product2.toString());
		}
		
	}

}
