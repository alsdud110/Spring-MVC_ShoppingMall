package product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.Member;

@Controller
public class ProductController {
	
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
	this.productService=productService;
	}

	//전체 상품 목록
	@RequestMapping("/product/List")
	public String list(Model model) {
		List<ProductVO> vo =productService.list();
		model.addAttribute("list",vo);
		return "product/productList";
	
	}
	
	//전체 상품 페이지 단위로 30개씩 나누어 가져오기
	@RequestMapping("/product/List/{page_num}")
	public String listPageNum(Model model, HttpServletRequest request, HttpSession session) {
		int num = Integer.valueOf(request.getParameter("page_num"));
		String page_num = "page " + Integer.toString(num);
		
		List<ProductVO> vo = null;
		
		if (session.getAttribute(page_num) == null) {
			vo = productService.listPageNum(num);
			
			session.setAttribute(page_num, vo);
		}
		else {
			vo = (List<ProductVO>) session.getAttribute(page_num);
		}
		
		session.setAttribute(page_num, vo);
		model.addAttribute("list",vo);
		return "product/productList";
	
	}
	
	@PostMapping("/product/search/{page_num}")
	public String listSearch(Model model, HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("search_name");
		int num = Integer.valueOf(request.getParameter("page_num"));
		String search_num = "search " + Integer.toString(num);
		List<ProductVO> vo = null;
		
		if (session.getAttribute(search_num) == null) {
			vo = productService.listSearch(num, name);
			
			session.setAttribute(search_num, vo);
		}
		else {
			vo = (List<ProductVO>) session.getAttribute(search_num);
		}
		
		session.setAttribute(search_num, vo);
		model.addAttribute("list",vo);
		return "product/productList";
	
	}
	
	//카테고리별 상품 목록
	@RequestMapping("/product/viewCategory/{kind}{value}")
	public String getListByCategory( @PathVariable("kind") String kind, Model model) {
		List<ProductVO> vo =productService.listByKind(kind);
		model.addAttribute("kind",vo);
		List<ProductVO> list =productService.byKind(kind);
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
	
	//상품 클릭시 상세 페이지로 이동.
	@RequestMapping("/productDetail/{code}")
	public String detailview(@PathVariable("code") String p_code, Model model, HttpServletRequest request) {
		
		String p_name = request.getParameter("p_name");
		String p_kind = request.getParameter("p_kind");
		String p_image = request.getParameter("p_image");
		int p_price = Integer.valueOf(request.getParameter("p_price"));
		int qty = Integer.valueOf(request.getParameter("qty"));
		List<ProductStdVO> stdvo=productService.productstd_selectByCode(p_code);
		
		Product vo = new Product(p_code, p_name, p_kind, p_image, p_price, qty);
		model.addAttribute("product", vo);
		model.addAttribute("productStd", stdvo);
		return "product/productDetail";
	}
	
	//카트나 구매하기 클릭시 사용
	@PostMapping("/addCart")  //form url 지정
	public String addCart(HttpServletRequest request, HttpSession session) {
		
		Member member = (Member)session.getAttribute("authInfo");
		String p_code = request.getParameter("p_name");
		String m_code = member.getM_code();
		String p_kind = request.getParameter("p_kind");
		String p_image = request.getParameter("p_image");
		int p_price = Integer.valueOf(request.getParameter("p_price"));
		int qty = Integer.valueOf(request.getParameter("qty"));
		
		return "product/123";
	}
	
}