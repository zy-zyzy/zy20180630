package cn.yd.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

//此类应该交给spring管理，因为前段是通过url地址访问而非id，因此可以不用指定名称
@Component
//访问当前controller的地址，地址为/工程名/product
@RequestMapping("/product")
public class ProductController {
	
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
	public void delete(Integer id) {
		
	}
	
}
