package com.tfl.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.getWriter().append("Server at:").append(request.getContextPath());
	}
}
