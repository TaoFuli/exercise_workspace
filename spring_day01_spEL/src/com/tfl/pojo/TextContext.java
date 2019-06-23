package com.tfl.pojo;

public class TextContext {
	private String name;
	private String value;
	private String info;
	public TextContext() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TextContext(String name, String value, String info) {
		super();
		this.name = name;
		this.value = value;
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
