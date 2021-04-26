package product;

public class ProductVO {

	private String P_CODE;
	private String P_NAME;
	private String P_KIND;
	private String P_IMAGE;
	private int P_PRICE;
	private int qty;

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public ProductVO() { }

	//값 불러와서 저장하기 위한 모든 값 구현.
	public ProductVO(String P_CODE, String P_NAME, String P_KIND, String P_IMAGE, int P_PRICE,int qty) {
		this.P_CODE=P_CODE;
		this.P_NAME=P_NAME;
		this.P_KIND=P_KIND;
		this.P_IMAGE=P_IMAGE;
		this.P_PRICE=P_PRICE;
		this.qty=qty;
	}
	
	public String getP_CODE() {
		return P_CODE;
	}
	public void setP_CODE(String p_CODE) {
		P_CODE = p_CODE;
	}
	public String getP_NAME() {
		return P_NAME;
	}
	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}
	public String getP_KIND() {
		return P_KIND;
	}
	public void setP_KIND(String p_KIND) {
		P_KIND = p_KIND;
	}
	public String getP_IMAGE() {
		return P_IMAGE;
	}
	public void setP_IMAGE(String p_IMAGE) {
		P_IMAGE = p_IMAGE;
	}
	public int getP_PRICE() {
		return P_PRICE;
	}
	public void setP_PRICE(int p_PRICE) {
		P_PRICE = p_PRICE;
	}

	
	
}
