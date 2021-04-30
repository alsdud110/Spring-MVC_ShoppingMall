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
	@RequestMapping("/product/viewCategory/{kind}{value}")
	public String getListByCategory( @PathVariable("kind") String kind, Model model) {
		List<ProductVO> vo =productService.listByKind(kind);
		model.addAttribute("kind",vo);
		String[] arr = kind.split("_");
		List<ProductVO> list =productService.byKind(arr[0]);
		model.addAttribute("list", list);
		return "product/CategoryList";
	}
//	//카테고리별 메뉴
//	@RequestMapping("/product/Category/{kind}")
//	public String CategoryBykind(@PathVariable("kind") String kind, Model model) {
//		List<ProductVO> list =productService.byKind(kind);
//		model.addAttribute("list", list);
//		return "product/CategoryMenu";
//	}
	//전체 상품 목록
	@RequestMapping("/product/List")
	public String list(Model model) {
		List<ProductVO> vo =productService.list();
		model.addAttribute("list",vo);
		return "product/productList";
	
	}
	

	//상품 클릭시 상세 페이지로 이동.
	@RequestMapping("/productDetail/{code}")
	public String detailview(@PathVariable("code") String code, Model model) {
		System.out.println("-------넘어온 코드값 = " + code);
		ProductVO vo =productService.product_selectByCode(code);
		List<ProductStdVO> stdvo=productService.productstd_selectByCode(code);
		model.addAttribute("product", vo);
		model.addAttribute("productStd", stdvo);
		return "product/productDetail";
		//return "product/prdocutDetail";
	}

	//구매 클릭시 사용
	@RequestMapping("productDetail/order")  //form url 지정
	public String orderview(Model model,CartVO cartVO) {
		model.addAttribute("CartVO", cartVO);
		//값 넘어 왔는지 확인.
		System.out.println("-----------------order테스트 =-=-=-=-=--------------------");
		System.out.println(" p_code " +cartVO.getP_code() +	" m_code " + cartVO.getM_code() +"p_name;" + cartVO.getP_name() +
				"p_image;" + cartVO.getP_image() + "p_price;" + cartVO.getP_price() + "qty;" + cartVO.getQty() +" p_size=" + cartVO.getP_size() 
				+" p_color=" +cartVO.getP_color() +"sumMoney;" + cartVO.getSumMoney());
			return "product/order";  //이동 페이지 지정.
	}
	
}