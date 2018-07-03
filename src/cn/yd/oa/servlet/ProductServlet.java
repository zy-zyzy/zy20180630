package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ssi.SSICommand;

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
		this.doPost(request, response);
		
	}

	//处理method=post的请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String type = request.getParameter("type");
		if (type.equals("save")) {
			//1、获取前端数据(在JAVA web中客户端返回的数据都被封装在request对象中)
			//从前端拿过来的都是string类型
			Product product = new Product();		
			product.setName(request.getParameter("name"));//<input type = "text" name="name" />
			product.setPrice(Double.parseDouble(request.getParameter("price")));//
			product.setRemark(request.getParameter("remark"));
			//2、调用业务逻辑
			productService.save(product);
			//3、调整到查询页面，在java中所有的资源访问都要从工程名开始（query.jsp）
			response.sendRedirect(request.getContextPath()+"/query.jsp");
		}
		else if (type.equals("query")) {
			String name = request.getParameter("keyword");
			HttpSession session = request.getSession();
			session.setAttribute("keyword", name);
			ArrayList<Product> products = productService.queryByName(name);
			request.setAttribute("proList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}
		else if (type.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			productService.delete(id);
			//采用之前的关键字进行查询
			HttpSession session = request.getSession();
			String keyword = (String)session.getAttribute("keyword");
			ArrayList<Product> products = productService.queryByName(keyword);
			request.setAttribute("proList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
