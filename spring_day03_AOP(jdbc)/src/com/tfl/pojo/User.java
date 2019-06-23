package com.tfl.pojo;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private String email;
	public User() {
		super();
	}
	public User(String name, String sex, Date birthday, String email) {
		super();
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", email=" + email
				+ "]";
	}
	
}
