package com.tfl.bean;

import org.springframework.stereotype.Component;
@Component
//@Service
//@Repository		//持久层组件注解
public class Tools {
	public double add(double a,double b) {
		return a+b;
	}
	public double sub(double a,double b) {
		return a-b;
	}
	public double multiplication(double a,double b) {
		return a*b;
	}
	public double division(double a,double b) {
		return a/b;
	}
}
