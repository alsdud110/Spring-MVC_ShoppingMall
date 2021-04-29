package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import product.ProductService;
import product.ProductVO;

@Controller
public class MainController {
	
	//최고 판마량 제품 보여주기위해 productService 추가
	ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService=productService;
		}
	//실행시 top3메소드 실행
	@RequestMapping("/main")
	public String handler(Model model) {
		List<ProductVO> top3=productService.listByTop3();
		model.addAttribute("top3",top3);
		return "main";
	}
	//실행시 top3메소드 실행
	@RequestMapping("/")
	public String main(Model model) {
//		List<ProductVO> top3=productService.listByTop3();
//		model.addAttribute("top3",top3);
		return "main";
	}

}
