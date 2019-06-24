package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domian.User;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("user");
		pw.println("<h2>首页</h2>");
		if(user!=null)
		{
			pw.println("欢迎光临："+user.getUsername()+"&nbsp;&nbsp;<a href='loginOut'>退出</a>");
		}
		else
		{
			pw.println("欢迎光临：游客。"+"<a href='login'>登陆</a>");
		}
		
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
