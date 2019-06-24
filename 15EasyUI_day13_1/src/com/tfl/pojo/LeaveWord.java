package com.tfl.pojo;

import java.util.Date;

public class LeaveWord {
	private int wid;
	private String wleaveWord;
	private String fk_uloginName;
	private Date wtime;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LeaveWord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWleaveWord() {
		return wleaveWord;
	}
	public void setWleaveWord(String wleaveWord) {
		this.wleaveWord = wleaveWord;
	}
	public String getFk_uloginName() {
		return fk_uloginName;
	}
	public void setFk_uloginName(String fk_uloginName) {
		this.fk_uloginName = fk_uloginName;
	}
	public Date getWtime() {
		return wtime;
	}
	public void setWtime(Date wtime) {
		this.wtime = wtime;
	}
	@Override
	public String toString() {
		return "LeaveWord [wid=" + wid + ", wleaveWord=" + wleaveWord + ", uloginName=" + fk_uloginName + ", wtime="
				+ wtime + "]";
	}
	public LeaveWord( String wleaveWord, String uloginName) {
		super();
		this.wleaveWord = wleaveWord;
		this.fk_uloginName = uloginName;
	}
}
