package com.tfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestRequestMethodController {
	
	/**
	 * 没有限制请求的方法    可以是get也可以是post请求
	 * @return
	 */
	@RequestMapping("/test1")
	public ModelAndView test1() {
		ModelAndView mv=new ModelAndView("show");
		return mv;
	}
	
	/**
	 * 限制只能是Get提交
	 */
	@RequestMapping(value="test2",method=RequestMethod.GET)
	public ModelAndView test2() {
		ModelAndView mv=new ModelAndView("show");
		return mv;
	}
	/**
	 * 限制只能post提交
	 * 
	 */
	@PostMapping("test3")
	public ModelAndView test3() {
		ModelAndView mv=new ModelAndView("show");
		return mv;
	}
	/**
	 * 限制只能get提交
	 * 
	 */
	@GetMapping("test4")
	public ModelAndView test4() {
		ModelAndView mv=new ModelAndView("show");
		return mv;
	}
}
