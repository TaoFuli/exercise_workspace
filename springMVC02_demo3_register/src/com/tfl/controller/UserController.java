package com.tfl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/reg.do")
	public void reg(@RequestParam(name="username",required=true,defaultValue="张杰")String username,
			@RequestParam(name="loginName",required=true)String loginName,
			@RequestParam(name="password",required=true)String password,
			@RequestParam(defaultValue="男")String sex,
			@RequestParam String birthday,
			@RequestParam String email,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//封装
		User user=new User(username,loginName,password,sex,birthday,email);
		//调用业务
		boolean b=service.addUser(user);
		if(b) {
			out.println("<h2>注册成功！</h2>");
		}else {
			out.println("<h2>注册失败！</h2>");
		}
	}
	@RequestMapping("/reg2.do")
	public  void  reg2(User user,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//调用业务
			boolean b = service.addUser(user);
			if(b) {
				out.println("<h1>注册成功</h1>");
			}else {
				out.println("<h1>注册失败</h1>");
			}
		}
}
