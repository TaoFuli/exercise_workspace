package com.tfl.pojo;

public class Person {
	private String name;
	private String message;
	public Person(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	public Person() {
		super();
		System.out.println("调用了构造方法！");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void say() {
		System.out.println(name+"说："+message);
	}
}
