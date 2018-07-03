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
	
	//����method=get������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	//����method=post������
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String type = request.getParameter("type");
		if (type.equals("save")) {
			//1����ȡǰ������(��JAVA web�пͻ��˷��ص����ݶ�����װ��request������)
			//��ǰ���ù����Ķ���string����
			Product product = new Product();		
			product.setName(request.getParameter("name"));//<input type = "text" name="name" />
			product.setPrice(Double.parseDouble(request.getParameter("price")));//
			product.setRemark(request.getParameter("remark"));
			//2������ҵ���߼�
			productService.save(product);
			//3����������ѯҳ�棬��java�����е���Դ���ʶ�Ҫ�ӹ�������ʼ��query.jsp��
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
			//����֮ǰ�Ĺؼ��ֽ��в�ѯ
			HttpSession session = request.getSession();
			String keyword = (String)session.getAttribute("keyword");
			ArrayList<Product> products = productService.queryByName(keyword);
			request.setAttribute("proList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
