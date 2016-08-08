package models;

public class User {

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	private String login;
	private String password;

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
