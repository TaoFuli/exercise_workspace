package com.igeek.app.servlet;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/loginchk")
public class LoginCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		if("admin".equals(username)&&"123".equals(password))
		{
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			// 如果用户之前访问了某个页面
			String origin_url = (String)session.getAttribute("origin_url");
			if(origin_url!=null)
			{
				resp.sendRedirect(origin_url);
			}
			else
			{
				resp.sendRedirect("main.jsp");
			}
		}
		else
		{
			resp.sendRedirect("login.jsp");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
