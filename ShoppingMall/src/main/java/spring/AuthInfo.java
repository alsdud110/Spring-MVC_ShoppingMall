package spring;

public class AuthInfo {

	private String m_id;
	private String m_email;
	private String m_name;
	private String m_contact;


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}



	public String getM_contact() {
		return m_contact;
	}



	public void setM_contact(String m_contact) {
		this.m_contact = m_contact;
	}



	public void setM_email(String m_email) {
		this.m_email = m_email;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public String getM_id() {
		return m_id;
	}



	public String getM_email() {
		return m_email;
	}



	public String getM_name() {
		return m_name;
	}



	public AuthInfo(String m_email, String m_name, String m_contact) {
		super();
		this.m_email = m_email;
		this.m_name = m_name;
		this.m_contact = m_contact;
	}







}
