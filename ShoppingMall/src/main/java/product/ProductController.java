package product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
	this.productService=productService;
	}


	//카테고리별 상품 목록
	@RequestMapping("/product/viewCategory/{kind}")
	public String getListByCategory( @PathVariable("kind") String kind, Model model) {
		List<ProductVO> vo =productService.listByKind(kind);
		model.addAttribute("kind",vo);
		return "product/CategoryList";
	}

	//전체 상품 목록
	@RequestMapping("/product/List")
	public String list(Model model) {
		List<ProductVO> vo =productService.list();
		model.addAttribute("list",vo);
		return "product/productList";
	
	}
	//main에 보여질 구매량 상위 3품목 
/*	@RequestMapping("/main")
	public String listByTOP3(Model model) {
		List<ProductVO> top3=productService.listByTop3();
		model.addAttribute("top3",top3);
		return "main";
	}
*/

}