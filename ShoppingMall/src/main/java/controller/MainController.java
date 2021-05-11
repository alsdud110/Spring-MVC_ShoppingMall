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
		//재고 파악
		for(int i=0; i<top3.size(); i++) {
			top3.set(i, productService.soldoutCheck(top3.get(i).getP_CODE()));
		}
		model.addAttribute("top3",top3);
		
		//신상품 순 top3
		List<ProductVO> newtop3=productService.listByNewTop3();
		//재고파악
		for(int i=0; i<newtop3.size(); i++) {
			newtop3.set(i, productService.soldoutCheck(newtop3.get(i).getP_CODE()));
		}
		model.addAttribute("newtop3",newtop3 );
		return "main";
	}
	
	@RequestMapping("/")
	public String main(Model model) {

		//주문량 순 top3
		List<ProductVO> top3=productService.listByTop3();
		//재고 파악
		for(int i=0; i<top3.size(); i++) {
			top3.set(i, productService.soldoutCheck(top3.get(i).getP_CODE()));
		}
		model.addAttribute("top3",top3);
		
		//신상품 순 top3
		List<ProductVO> newtop3=productService.listByNewTop3();
		//재고파악
		for(int i=0; i<newtop3.size(); i++) {
			newtop3.set(i, productService.soldoutCheck(newtop3.get(i).getP_CODE()));
		}
		model.addAttribute("newtop3",newtop3 );
		return "main";
	}

}
