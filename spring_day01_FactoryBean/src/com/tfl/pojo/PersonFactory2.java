package com.tfl.pojo;

public class PersonFactory2 {
	public Person createPerson() {
		return new Person("李四","你是个锅");
	}
	public Person createPerson2() {
		return new Person("李四","你是个屁");
	}
}
