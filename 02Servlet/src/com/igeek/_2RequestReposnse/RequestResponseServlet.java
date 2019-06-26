package com.igeek._2RequestReposnse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginchk")
public class RequestResponseServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpServletRequest req			封装了用户的而请求信息
		// HttpServletResponse resp			用来给用户发信息的对象
		
		String username =  req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username:"+username+",password="+password);
		
		String[] likes = req.getParameterValues("like");
		System.out.println(Arrays.toString(likes));
		
		PrintWriter pw = resp.getWriter();
		if("admin".equals(username)&&"123".equals(password))
		{
			pw.println("login ok.");
		}
		else
		{
			pw.println("login failed.");
		}
		
			
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
