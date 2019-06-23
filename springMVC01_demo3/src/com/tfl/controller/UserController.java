package com.tfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/login.php")
	public ModelAndView doLogin(String username,String password) {
		ModelAndView mv=new ModelAndView();
		User user=service.login(username, password);
		if(user!=null) {
			mv.setViewName("/WEB-INF/views/success.jsp");
		}else {
			mv.setViewName("/WEB-INF/views/fail.jsp");
		}
		return mv;
	} 
}
