package com.tfl.pojo;

public class Users {
	private int id;
	private String username;
	private String loginName;
	private String password;
	private String email;
	private String relName;
	private String sex;
	private String registerTime;
	public Users() {	}
	public Users(int id, String username, String loginName, String password, String email, String relName, String sex,
			String registerTime) {
		super();
		this.id = id;
		this.username = username;
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.relName = relName;
		this.sex = sex;
		this.registerTime = registerTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", loginName=" + loginName + ", password=" + password
				+ ", email=" + email + ", relName=" + relName + ", sex=" + sex + ", registerTime=" + registerTime + "]";
	}
	
}
