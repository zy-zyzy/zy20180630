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
	
	//处理method=get的请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		//3、返回结果页面
	}

}
