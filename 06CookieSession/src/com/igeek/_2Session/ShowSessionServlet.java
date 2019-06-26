package com.igeek._2Session;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ShowSessionServlet")
public class ShowSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 得到Session对象
		HttpSession session = req.getSession();
		pw.println("sessionID:"+session.getId()+"<br />");
		
		// 2. 显示Session中的信息
		pw.println("name1:"+session.getAttribute("name1"));
		pw.println("name2:"+session.getAttribute("name2"));
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
