package com.igeek.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginchk")
public class LoginCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 接收用户提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 2. 处理数据
		// 3. 返回信息
		
		resp.setContentType("text/html;charset=utf-8"); 
		PrintWriter pw = resp.getWriter();
		if("admin".equals(username)&&"123".equals(password))
		{
			pw.println("登录成功");
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

