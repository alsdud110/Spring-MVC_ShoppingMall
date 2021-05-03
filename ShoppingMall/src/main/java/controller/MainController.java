package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import product.ProductService;
import product.ProductVO;

@Controller
public class MainController {
	
	// 메인에 표시할 상품을 위해 추가.
	ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService=productService;
	}

	@RequestMapping("/main")
	public String handler(Model model) {
		//주문량 순 top3
		List<ProductVO> top3=productService.listByTop3();
		model.addAttribute("top3",top3);
		//신상품 순 top3
		List<ProductVO> newtop3=productService.listByNewTop3();
		model.addAttribute("newtop3",newtop3 );
		return "main";
	}
	
	@RequestMapping("/")
	public String main(Model model) {

		//주문량 순 top3
		List<ProductVO> top3=productService.listByTop3();
		model.addAttribute("top3",top3);
		//신상품 순 top3
		List<ProductVO> newtop3=productService.listByNewTop3();
		model.addAttribute("newtop3",newtop3 );

		return "main";
	}

}
