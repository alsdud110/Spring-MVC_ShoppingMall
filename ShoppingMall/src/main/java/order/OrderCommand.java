package order;

public class OrderCommand {
	private String m_code;
	private String p_code;
	private int qty;
	private String addr_road;
	private String addr_detail;
	private String o_addr;
	private String name;
	private String contact;
	
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr_road() {
		return addr_road;
	}
	public void setAddr_road(String addr_road) {
		this.addr_road = addr_road;
	}
	public String getAddr_detail() {
		return addr_detail;
	}
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getO_addr() {
		return addr_road +", " + addr_detail;
	}
	public void setO_addr(String o_addr) {
		this.o_addr = o_addr;
	}
	
	
	
}
