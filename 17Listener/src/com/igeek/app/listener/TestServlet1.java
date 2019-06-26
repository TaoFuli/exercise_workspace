package com.igeek.app.listener;

import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/TestServlet1")
public class TestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		ServletContext sc = getServletContext(); 
		sc.setAttribute("username", "zhangsan");
		sc.setAttribute("username", "lisi");
		sc.removeAttribute("username");
		
		HttpSession session = req.getSession();
		session.setAttribute("username", "xiaoming");
		session.setAttribute("username", "daming");
		session.removeAttribute("username");
		session.setMaxInactiveInterval(3*60);
		
		req.setAttribute("username", "zhangfei");
		req.setAttribute("username", "zhaoyu");
		req.removeAttribute("username");
		
		resp.sendRedirect("test.jsp");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

