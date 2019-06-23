package com.tfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestSpringMvcExceptionController {
	
	@GetMapping
	public String doSomething() {
		return "show";
	}
	@GetMapping("/test")
	public String dodo() {
		int[] arr=new int[3];
		arr[3]=100;
		return "show";
	}
	
}
