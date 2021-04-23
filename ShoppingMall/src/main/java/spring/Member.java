package spring;

import java.sql.Date;

public class Member {
	
	private String m_code;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_addr;
	private String m_contact;
	private String m_email;
	private Date reg_login;

	public Member(String m_code, String m_id, String m_pw, String m_name, String m_addr, String m_contact,
			String m_email, Date reg_login) {
		super();
		this.m_code = m_code;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_addr = m_addr;
		this.m_contact = m_contact;
		this.m_email = m_email;
		this.reg_login = reg_login;
	}

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

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
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

	public Date getReg_login() {
		return reg_login;
	}

	public void setReg_login(Date reg_login) {
		this.reg_login = reg_login;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!m_pw.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.m_pw = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.m_pw.equals(password);
	}

}
