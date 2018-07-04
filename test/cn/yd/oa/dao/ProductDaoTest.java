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
		System.out.println("�˷����ڲ��Է���֮ǰִ�У�ͨ��������ʼ�����Զ���");
		//productDao = new ProductDao();	
		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		productService = context.getBean("ps",ProductService.class);
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮��ִ�У�ͨ�������ͷ���Դ");
		productService = null;
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("��Ϊ�ֻ�");
		product.setPrice(2800.00);
		product.setRemark("��ΪP10");
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
		product.setName("��Ϊ�ֻ�");
		product.setPrice(2800.00);
		product.setRemark("��ΪP10");
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
