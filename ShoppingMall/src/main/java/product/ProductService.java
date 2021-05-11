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
	
	public List<ProductVO> listPageNum(int num) {
		List<ProductVO> vo = productDAO.selectAllByPage(num);
		System.out.println("--------selectAll 데이터 요청 확인하기---------------");
		for (ProductVO m : vo) { 
			System.out.println("P_CODE=" + m.getP_CODE() + ", " +"P_NAME=" + m.getP_NAME() + ", " +
					"P_KIND=" + m.getP_KIND() + ", " +"P_IMAGE=" + m.getP_IMAGE() + ", " + "P_PRICE=" + m.getP_PRICE());
			}
		return vo;
	}
	
	public List<ProductVO> listSearch(int num, String any_name) {
		List<ProductVO> vo = productDAO.selectSearch(num, any_name);
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
	//코드와 관련된 상품목록
	public ProductVO product_selectByCode(String code) {
		ProductVO list = productDAO.productselectByCode(code);
		return list;
	}
	//코드와 관련된 상품 규격 목록
	public List<ProductStdVO> productstd_selectByCode(String code) {
		List<ProductStdVO> list = productDAO.productstdselectByCode(code);
		return list;
	}
	//구매수량 높은순 상위 3품목
	public List<ProductVO> listByTop3(){
		List<ProductVO> top3=productDAO.top3();
		return top3;
	}
	//상품 종류만 있는 목록
	public List<ProductVO> byKind(String kind){
		List<ProductVO> list = productDAO.listByKind(kind);
		return list;
	}
	//신상품 목록
	public List<ProductVO> listByNewTop3(){
		List<ProductVO> newtop3=productDAO.newProductTop3();
		return newtop3;
	}
	//품절 확인
	public ProductVO soldoutCheck(String code){
		System.out.println("========서비스 soldout 코드 " + code);
		ProductVO vo=productDAO.productselectByCode(code);
		System.out.println("soldout 서비스 추가전 값" + vo.getProductstdvo());
		List<ProductStdVO> stdvo = productDAO.productstdselectByCode(vo.getP_CODE());
		for (int i = 0; i < stdvo.size(); i++) {
			if (stdvo.get(i).getStock() == 0)
					stdvo.remove(i); // 재고가 0이면 해당 ProductStdVO 삭제.
			// ProductVo 안의 List<ProductStd> 배열에 추가.
			vo.setProductstdvo(stdvo);
		}
		return vo;
	}
	
	
}
