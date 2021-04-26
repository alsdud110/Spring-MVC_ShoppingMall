package product;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	//전체 상품 목록
	public List<ProductVO> list() {
		List<ProductVO> vo = productDAO.selectAll();
		System.out.println("--------selectAll 데이터 요청 확인하기---------------");
		for (ProductVO m : vo) { 
			System.out.println("P_CODE=" + m.getP_CODE() + ", " +"P_NAME=" + m.getP_NAME() + ", " +
					"P_KIND=" + m.getP_KIND() + ", " +"P_IMAGE=" + m.getP_IMAGE() + ", " + "P_PRICE=" + m.getP_PRICE());
			}
		return vo;
	}
	//종류별 상품 목록
	public List<ProductVO> listByKind(String kind) {
		List<ProductVO> list = productDAO.selectByKind(kind);
		System.out.println("--------selectByKind 데이터 요청 확인하기---------------");
		for (ProductVO m : list) { 
			System.out.println("P_CODE=" + m.getP_CODE() + ", " +"P_NAME=" + m.getP_NAME() + ", " +
					"P_KIND=" + m.getP_KIND() + ", " +"P_IMAGE=" + m.getP_IMAGE() + ", " + "P_PRICE=" + m.getP_PRICE());
			}

		return list;
	}
	
	public List<ProductVO> product_selectByCode(String code) {
		List<ProductVO> list = productDAO.productselectByCode(code);
		System.out.println("-----------product_selectByCode --------------");
		for (ProductVO m : list) { 
			System.out.println("P_CODE=" + m.getP_CODE() + ", " +"P_NAME=" + m.getP_NAME() + ", " +
					"P_KIND=" + m.getP_KIND() + ", " +"P_IMAGE=" + m.getP_IMAGE() + ", " + "P_PRICE=" + m.getP_PRICE());
			}
		return list;
	}
	
	public List<ProductStdVO> productstd_selectByCode(String code) {
		List<ProductStdVO> list = productDAO.productstdselectByCode(code);
		System.out.println("-----------productstd_selectByCode --------------");
		for (ProductStdVO m : list) { 
			System.out.println("P_CODE=" + m.getP_code() + ", " +"P_COLOR=" + m.getP_color() + ", " +
					"P_SIZE=" + m.getP_size() + ", " +"STOCK=" + m.getStock());
			}
		return list;
	}
	//구매수량 높은순 상위 3품목
/*	public List<ProductVO> listByTop3(){
		List<ProductVO> top3=productDAO.top3();
		return top3;
	}
*/	
}
