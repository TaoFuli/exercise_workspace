package com.tfl.pojo;

public class Person {
	private String name;
	private String message;
	public void init() {
		System.out.println("初始化了Person类");
	}
	public void destory() {
		System.out.println("Person销毁了");
	}
	public void say() {
		System.out.println(name+"说："+message);
	}
	public Person() {
		super();
		System.out.println("调用了构造方法");
	}
	public Person(String name, String message) {
		super();
		this.name = name;
		this.message = message;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", message=" + message + "]";
	}
	
}
