package com.igeek._1Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("调用了doGet方法");
		
		// 通过响应对象给用户发送信息
		PrintWriter pw = resp.getWriter();
		// 
		pw.println("doGet() Hello world.");
		// 
		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("调用了doPost()方法处理用户的post请求");
	}
}
