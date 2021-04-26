package product;

public class ProductStdVO {

	private String p_size;
	private String p_color;
	private String p_code;
	private int stock;
	
	public ProductStdVO() {}
	
	public ProductStdVO(String p_size,String p_color,String p_code,int stock) {
		this.p_size=p_size;
		this.p_color=p_color;
		this.p_code=p_code;
		this.stock=stock;
	}
	
	public String getP_size() {
		return p_size;
	}
	public void setP_size(String p_size) {
		this.p_size = p_size;
	}
	public String getP_color() {
		return p_color;
	}
	public void setP_color(String p_color) {
		this.p_color = p_color;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
