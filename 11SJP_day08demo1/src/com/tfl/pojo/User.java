package com.tfl.pojo;

public class User {
	private int uid;
	private String username;
	private String uloginName;
	private String upassword;
	private String usex;
	private String ubirthday;
	private String uemail;
	private String ucreateTime;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String username, String uloginName, String upassword,  String usex,
			String ubirthday, String uemail, String ucreateTime) {
		this.uid = uid;
		this.username = username;
		this.uloginName = uloginName;
		this.upassword = upassword;
		this.usex = usex;
		this.ubirthday = ubirthday;
		this.uemail = uemail;
		this.ucreateTime = ucreateTime;
	}
	public String getUbirthday() {
		return ubirthday;
	}

	public void setUbirthday(String ubirthday) {
		this.ubirthday = ubirthday;
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
	public String getUloginName() {
		return uloginName;
	}
	public void setUloginName(String uloginName) {
		this.uloginName = uloginName;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcreateTime() {
		return ucreateTime;
	}
	public void setUcreateTime(String ucreateTime) {
		this.ucreateTime = ucreateTime;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", uloginName=" + uloginName + ", upassword=" + upassword
				+  ", usex=" + usex + ", uemail=" + uemail + ", ucreateTime="
				+ ucreateTime + "]";
	}
	
}
