package com.mf.生命周期;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HelloServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 被调用了");
		
		//设置响应内容的MIME类型和编码方式
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("doGet():Hello world!");
		pw.println("中文汉字编码");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost():被调用了Hello world!");
		PrintWriter pw=response.getWriter();
		pw.println("doPost() :Hello World汉字");
		doGet(request, response);
	}

}
