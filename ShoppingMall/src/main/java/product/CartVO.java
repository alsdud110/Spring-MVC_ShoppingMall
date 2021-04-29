package product;

public class CartVO {
	private String p_code;
	private String m_code;
    private String p_name;
    private String p_image;
    private int p_price;
    private int qty;
    private String p_size;
    private String p_color;
    private int sumMoney;//선택한 상품별 총금액?
    private String str;
   
    
    public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public CartVO() {}
    
    public CartVO(String p_code, String m_code, String p_name,String p_image,
    		int p_price,int qty,String p_size,String p_color,int sumMoney) {
    	this.m_code=m_code;
    	this.p_code=p_code;
    	this.p_color=p_color;
    	this.p_image=p_image;
    	this.p_price=p_price;
    	this.qty=qty;
    	this.p_size=p_size;
    	this.p_color=p_color;
    	this.sumMoney=sumMoney;
    }
    
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_image() {
		return p_image;
	}
	public void setP_image(String p_image) {
		this.p_image = p_image;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
	public int getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(int sumMoney) {
		this.sumMoney = qty*p_price;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
}
