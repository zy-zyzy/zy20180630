package cn.yd.oa.servlet;

import java.io.IOException;
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
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
 
	private ProductService productService = new ProductService();
	
	//����method=get������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		//3�����ؽ��ҳ��
	}

}
