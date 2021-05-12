package product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 전체 상품 목록
	@RequestMapping("/product/List")
	public String list(Model model) {
		List<ProductVO> vo = productService.list();
		model.addAttribute("list", vo);
		return "product/productList";
	}

	// 전체 상품 페이지 단위로 30개씩 나누어 가져오기
	@RequestMapping("/product/List/{page_num}")
	public String listPageNum(Model model, HttpServletRequest request, HttpSession session) {
		int num = Integer.valueOf(request.getParameter("page_num"));
		String page_num = "page " + Integer.toString(num);

		List<ProductVO> vo = null;

		if (session.getAttribute(page_num) == null) {
			vo = productService.listPageNum(num);

			session.setAttribute(page_num, vo);
		} else {
			vo = (List<ProductVO>) session.getAttribute(page_num);
		}

		session.setAttribute(page_num, vo);
		model.addAttribute("list", vo);
		return "product/productList";
	}

	// 상품 검색하기
	@PostMapping("/product/search/{page_num}")
	public String listSearch(Model model, HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("search_name");
		int num = Integer.valueOf(request.getParameter("page_num"));
		String search_num = "search " + Integer.toString(num);
		List<ProductVO> vo = null;

		if (session.getAttribute(search_num) == null) {
			vo = productService.listSearch(num, name);

			session.setAttribute(search_num, vo);
		} else {
			vo = (List<ProductVO>) session.getAttribute(search_num);
		}

		session.setAttribute(search_num, vo);
		model.addAttribute("list", vo);
		return "product/productList";

	}

	@RequestMapping("/product/viewCategory/{kind}")
	public String getListByCategory(@PathVariable String kind, Model model) {
		List<ProductVO> vo = productService.listByKind(kind);
		//재고에 따른 품절 확인
		for(int i=0; i<vo.size(); i++) {
			vo.set(i, productService.soldoutCheck(vo.get(i).getP_CODE()));
		}
		model.addAttribute("kind", vo);
		
		String[] arr = kind.split(" ");
		List<ProductVO> list = productService.byKind(arr[0]);
		model.addAttribute("list", list);
		return "product/CategoryList";
	}


	// 상품 클릭시 상세 페이지로 이동.
	@RequestMapping("/productDetail/{code}")
	public String detailview(@PathVariable("code") String p_code, Model model, HttpServletRequest request) {
		List<ProductStdVO> stdvo = productService.productstd_selectByCode(p_code);
		ProductVO vo = productService.product_selectByCode(p_code);
		model.addAttribute("product", vo);
		model.addAttribute("productStd", stdvo);
		return "product/productDetail";
	}
	
}