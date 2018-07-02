package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
//@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
 
	private ProductService productService = new ProductService();
	
	//����method=get������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.queryByName(keyword);
		for(Product tmProduct :products) {
			System.out.println(tmProduct);
		}
	}

	//����method=post������
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡǰ������(��JAVA web�пͻ��˷��ص����ݶ�����װ��request������)
		//��ǰ���ù����Ķ���string����
		Product product = new Product();		
		product.setName(request.getParameter("name"));//<input type = "text" name="name" />
		product.setPrice(Double.parseDouble(request.getParameter("price")));//
		product.setRemark(request.getParameter("remark"));
		//2������ҵ���߼�
		productService.save(product);
		//3����������ѯҳ�棬��java�����е���Դ���ʶ�Ҫ�ӹ�������ʼ��query.jsp��
		response.sendRedirect("/zy20180630/query.jsp");
	}

}
