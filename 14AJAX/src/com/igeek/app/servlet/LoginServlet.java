package com.igeek.app.servlet;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();

		// 1. 接收用户提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String age = req.getParameter("age");

		// 2. 处理数据
		// 3. 返回信息
		if ("admin".equals(username) && "123".equals(password) && Integer.parseInt(age)>=18) {
			//pw.println("登录成功");
			
			pw.println("{\"result\":\"登录成功\","
					+ "\"username\":\""+username+"\"}");
		} else {
			
			pw.println("{\"result\":\"登录失败\"}");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
