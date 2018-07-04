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

//����Ӧ�ý���spring������Ϊǰ����ͨ��url��ַ���ʶ���id����˿��Բ���ָ������
@Component
//���ʵ�ǰcontroller�ĵ�ַ����ַΪ/������/product
@RequestMapping("/product")
public class ProductController {
	
	@Resource
	private HttpServletRequest request;
	@Resource
	private HttpSession session;
	
	@Resource(name="ps")
	private ProductService productService;

	//servletֻ�ṩdoget��dopost��������controllerΪÿ������ָ������
	//mvc֧���Զ���ֵ��ǰ���ı����name����Ҫ��product����ƥ��
	@RequestMapping("/save")
	public String save(Product product) {
		//1����ȡǰ���������ݣ�mvc����ɣ�
		//2������ҵ���߼�
		productService.save(product);
		//3�����ؽ��ҳ�棬��ת����ѯҳ�棬��ǰcontroller��query.jspû�����ݽ�����������ض���
		return "redirect:/query.jsp";//spring mvc�в�����ת�������ض���Ĭ������˹�����
		
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
