package cn.yd.oa.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

//此类应该交给spring管理，因为前段是通过url地址访问而非id，因此可以不用指定名称
@Component
//访问当前controller的地址，地址为/工程名/product
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	@Resource(name="ps")
	private ProductService productService;

	//servlet只提供doget和dopost方法，而controller为每个请求都指定方法
	//mvc支持自动赋值，前端文本框的name属性要和product属性匹配
	@RequestMapping("/save")
	public String save(Product product) {
		//1、获取前端请求数据（mvc已完成）
		//2、调用业务逻辑
		productService.save(product);
		//3、返回结果页面，跳转到查询页面，当前controller与query.jsp没有数据交互，因此用重定向
		return "redirect:/query.jsp";//spring mvc中不管是转发还是重定向都默认添加了工程名
		
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		productService.delete(id);
		String keyword = (String)session.getAttribute("keyword");
		ArrayList<Product> products = productService.queryByName(keyword);
		request.setAttribute("proList", products);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
		
		
	}
	
	@RequestMapping("/query")
	public  String queryByName(String keyword) {
		//ProductDao productDao = new ProductDao();
		//ArrayList<Product> products =productDao.queryByName(name);
		ArrayList<Product> products = productService.queryByName(keyword);
		System.out.println(products.size());
		request.setAttribute("proList", products);
		session.setAttribute("keyword", keyword);
		return "forward:/query.jsp";
		
	}
	
	@RequestMapping("/getbyid")
	public  String getById(Integer id) {
		Product product = productService.getById(id);
		request.setAttribute("product", product);
		return "forward:/update.jsp";
	}
	
	@RequestMapping("/update")
	public  String update(Product product) {
		productService.update(product);
		return "forward:/query.jsp";
	}
	
}
