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
	
	//处理method=get的请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.queryByName(keyword);
		for(Product tmProduct :products) {
			System.out.println(tmProduct);
		}
	}

	//处理method=post的请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取前端数据(在JAVA web中客户端返回的数据都被封装在request对象中)
		//从前端拿过来的都是string类型
		Product product = new Product();		
		product.setName(request.getParameter("name"));//<input type = "text" name="name" />
		product.setPrice(Double.parseDouble(request.getParameter("price")));//
		product.setRemark(request.getParameter("remark"));
		//2、调用业务逻辑
		productService.save(product);
		//3、调整到查询页面，在java中所有的资源访问都要从工程名开始（query.jsp）
		response.sendRedirect("/zy20180630/query.jsp");
	}

}
