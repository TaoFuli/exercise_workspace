package com.tfl.pojo;

public class PersonFactory {
	public static Person createPerson() {
		return new Person("李四","我是一个帅哥");
	}
	public static Person createPerson2() {
		return new Person("王五","我是一个美女");
	}
}
