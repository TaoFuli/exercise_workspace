package com.tfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfl.pojo.User;

@Controller
public class TestRequestParamsController2 {
	
	@RequestMapping("/get1.do")
	public void baseType(Integer a,Boolean b,Float c,Double d,String s) {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
	}
	@RequestMapping("/get2.do")
	public void pojoType(User user) {
		System.out.println("接收到的user:"+user);
	}
}
