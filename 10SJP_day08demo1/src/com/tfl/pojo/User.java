package com.tfl.pojo;

public class User {
	private int id;
	private String username;
	private String loginName;
	private String sex;
	private String birthday;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public User(int id, String username, String loginName, String sex, String birthday) {
		super();
		this.id = id;
		this.username = username;
		this.loginName = loginName;
		this.sex = sex;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginName=" + loginName + ", sex=" + sex + ", birthday="
				+ birthday + "]";
	}
	
}
