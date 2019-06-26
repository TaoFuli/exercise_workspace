package com.igeek._3Example1;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		ShowSessionUtils.showSessionInfo(req, pw);
		
		HttpSession s = req.getSession();
		pw.println("用户"+s.getAttribute("username")+"已登录");
		
		
		pw.println("<a href=\"logout\">登出</a>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
