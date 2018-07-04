package cn.yd.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

//����Ӧ�ý���spring������Ϊǰ����ͨ��url��ַ���ʶ���id����˿��Բ���ָ������
@Component
//���ʵ�ǰcontroller�ĵ�ַ����ַΪ/������/product
@RequestMapping("/product")
public class ProductController {
	
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
	public void delete(Integer id) {
		
	}
	
}
