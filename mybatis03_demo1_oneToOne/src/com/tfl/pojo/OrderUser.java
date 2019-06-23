package com.tfl.pojo;

import java.util.Date;

public class OrderUser extends Order {
	private int uid;
	private String username;
	private String loginName;
	private String password;
	private String sex;
	private Date birthday;
	private String email;
	public OrderUser() {
		super();
	}
	
	public OrderUser(String username, String loginName, String password, String sex, Date birthday, String email) {
		super();
		this.username = username;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
	}

	public OrderUser(int uid, String username, String loginName, String password, String sex, Date birthday,
			String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
		return "OrderUser [uid=" + uid + ", username=" + username + ", loginName=" + loginName + ", password="
				+ password + ", sex=" + sex + ", birthday=" + birthday + ", email=" + email + "]"
				+"Order [oid=" + getOid() + ", createtime=" + getCreatetime() + ", orderStatus=" + getOrderStatus() + "]";
	}
	
}
