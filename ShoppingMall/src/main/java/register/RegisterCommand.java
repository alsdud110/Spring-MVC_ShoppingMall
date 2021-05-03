package register;

import java.time.LocalDateTime;

public class RegisterCommand {

	private String m_code;
	private String m_id;		//민영
	private String m_pw;		//1234
	private String m_confirmpw;	//1234
	private String m_name;		
	private String year;
	private String month;
	private String day;
	private String m_birth;
	private String addr_road;
	private String addr_detail;
	private String m_addr;
	private String m_contact;
	private String m_email;
	private LocalDateTime rec_login;

	public String getM_code() {
		return m_code;
	}

	public void setM_code(String m_code) {
		this.m_code = m_code;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_confirmpw() {
		return m_confirmpw;
	}

	public void setM_confirmpw(String m_confirmpw) {
		this.m_confirmpw = m_confirmpw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_birth() {
		return year + month + day;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_addr() {
		return addr_road + " ," + addr_detail;
	}
	
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
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

	public String getM_contact() {
		return m_contact;
	}

	public void setM_contact(String m_contact) {
		this.m_contact = m_contact;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public LocalDateTime getRec_login() {
		return rec_login;
	}

	public void setRec_login(LocalDateTime rec_login) {
		this.rec_login = rec_login;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}






	public boolean isPasswordEqualToConfirmPassword() {
		return m_pw.equals(m_confirmpw);
	}


}
