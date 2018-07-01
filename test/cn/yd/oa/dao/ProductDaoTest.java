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
		System.out.println("�˷����ڲ��Է���֮ǰִ�У�ͨ��������ʼ�����Զ���");
		productDao = new ProductDao();	
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮��ִ�У�ͨ�������ͷ���Դ");
		productDao = null;
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
		Product product = new Product();
		product.setName("��Ϊ�ֻ�");
		product.setPrice(2800.00);
		product.setRemark("��ΪP10");
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
		product.setName("��Ϊ�ֻ�");
		product.setPrice(2800.00);
		product.setRemark("��ΪP10");
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
