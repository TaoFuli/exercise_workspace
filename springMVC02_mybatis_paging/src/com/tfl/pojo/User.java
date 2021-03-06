package com.tfl.pojo;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String loginName;
	private String password;
	private String sex;
	private Date birthday;
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String loginName, String password, String sex, Date birthday, String email) {
		super();
		this.username = username;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
	}
	public User(int id, String username, String loginName, String password, String sex, Date birthday, String email) {
		super();
		this.id = id;
		this.username = username;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginName=" + loginName + ", password=" + password
				+ ", sex=" + sex + ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	
}
