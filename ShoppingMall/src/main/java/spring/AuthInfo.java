package spring;

public class AuthInfo {

	private String m_id;
	private String m_email;
	private String m_name;



	public String getM_id() {
		return m_id;
	}



	public String getM_email() {
		return m_email;
	}



	public String getM_name() {
		return m_name;
	}



	public AuthInfo(String m_id, String m_name) {
		this.m_id = m_id;
		this.m_name = m_name;
	}



}
