package cart;


public class CartDTO {

	    private String p_name;
	    private String p_image;
	    private int p_price;
	    private int qty;
	    private String p_size;
	    private String p_color;
	    private int sumMoney;//선택한 상품별 총금액?
	    
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
			this.sumMoney = sumMoney;
		}
}
 
	    
	 