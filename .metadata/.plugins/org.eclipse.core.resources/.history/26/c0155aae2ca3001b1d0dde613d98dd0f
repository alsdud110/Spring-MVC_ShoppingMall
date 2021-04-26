package spring;

import java.time.LocalDateTime;

public class Member {

	private String id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

}
