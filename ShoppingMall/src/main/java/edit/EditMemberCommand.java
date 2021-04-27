package edit;

import java.time.LocalDateTime;

public class EditMemberCommand {

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
	private LocalDateTime reg_login;
	
	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_birth() {
		if(Integer.parseInt(month) >= 10) {
			this.month = month;
		}else {
			this.month = "0"+month;
		}
		if(Integer.parseInt(day) >= 10) {
			this.day = month;
		}else {
			this.day = "0"+day;
		}
		return year + "년 " + month + "월 " + day + "일";
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_addr() {
		return addr_road + " " + addr_detail;
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

	public LocalDateTime getReg_login() {
		return reg_login;
	}

	public void setReg_login(LocalDateTime reg_login) {
		this.reg_login = reg_login;
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










}
