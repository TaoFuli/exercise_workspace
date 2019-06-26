package com.igeek.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cal")
public class CalculaterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 获取参数
		String aStr = req.getParameter("a");
		String bStr = req.getParameter("b");
		String op = req.getParameter("op");
		
		System.out.println("a="+aStr);
		System.out.println("b="+bStr);
		System.out.println("op="+op);
		
		
		
		// 2.  进行计算
		int a = Integer.parseInt(aStr);
		int b = Integer.parseInt(bStr);
		int result = 0;
		switch(op)
		{
		case "+":
			result = a+b;
			break;
		case "-":
			result = a-b;
			break;
		case "*":
			result = a*b;
			break;
		case "/":
			result = a/b;
			break;
		}
		
		// 3. 输出结果
		pw.println(a+op+b+"="+result);
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}



//package com.igeek.test;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/cal")
//class CalculaterServlet extends HttpServlet{
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		
//		// 1. 获取参数
//		String a = req.getParameter("a");
//		String b = req.getParameter("b");
//		String op = req.getParameter("op");
//		
//		System.out.println("a="+a);
//		System.out.println("b="+b);
//		System.out.println("op="+op);
//		
//		// 2. 处理
//		
//		// 3. 打印显示
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
//	{
//		// TODO Auto-generated method stub
//		//doGet(req, resp);
//	}
//}
