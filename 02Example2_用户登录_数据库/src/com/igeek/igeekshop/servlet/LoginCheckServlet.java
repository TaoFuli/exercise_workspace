package com.igeek.igeekshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.igeekshop.domain.User;
import com.igeek.igeekshop.service.UserService;

@WebServlet("/loginchk")
public class LoginCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 接收参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 2. 调用业务层方法处理
		UserService us = new UserService();
		User user = us.login(username, password);
		
		// 3. 显示结果
		if(user!=null)
		{
			pw.println(user.getUsername()+"登录成功");
		}
		else
		{
			pw.println("登录失败");
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
