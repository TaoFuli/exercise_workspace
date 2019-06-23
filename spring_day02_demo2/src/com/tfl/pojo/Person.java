package com.tfl.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person1")
public class Person {
	private String name="张三";
	@Value("李四我喜欢你")
	private String message;

	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	@Value("注入王五")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
