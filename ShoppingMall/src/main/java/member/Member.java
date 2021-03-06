package member;


import java.sql.Timestamp;

import login.WrongIdPasswordException;

public class Member {
	public Member() {}
	
	private String m_code;
	private String m_id;
	private String m_pw;
	private String m_addr;
	private String m_contact;
	private String m_email;
	private Timestamp rec_login;
	private String year;
	private String month;
	private String day;
	private String m_birth;
	private String m_name;

	//MemberRegisterService => Register Member 등록
	//AuthService => session에 member 정보 등록
	public Member(String m_code, String m_id, String m_pw, String m_addr, String m_contact, String m_email, String m_birth,
			String m_name) {
		super();
		this.m_code = m_code;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_addr = m_addr;
		this.m_contact = m_contact;
		this.m_email = m_email;
		this.m_birth = m_birth;
		this.m_name = m_name;
	}
	
	public Member(String m_code, String m_addr, String m_contact, String m_email, String m_birth,
			String m_name) {
		super();
		this.m_code = m_code;
		this.m_addr = m_addr;
		this.m_contact = m_contact;
		this.m_email = m_email;
		this.m_birth = m_birth;
		this.m_name = m_name;
	}
	
	//회원 정보 수정 시 생년월일 값
	//----------------------------------------
	public String getYear() {
		return m_birth.substring(0,4);
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMonth() {
		return m_birth.substring(4,6);
	}
	
	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return m_birth.substring(6, 8);
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	//------------------------------------------
	
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

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
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

	public Timestamp getRec_login() {
		return rec_login;
	}

	public void setRec_login(Timestamp rec_login) {
		this.rec_login = rec_login;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void changePassword(String m_code, String oldPassword, String newPassword) {
		if (!m_pw.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.m_pw = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.m_pw.equals(password);
	}

}
