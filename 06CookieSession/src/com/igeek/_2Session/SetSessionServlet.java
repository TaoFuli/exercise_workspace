package com.igeek._2Session;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 得到Session对象
		HttpSession session = req.getSession();
		pw.println("sessionID:"+session.getId()+"<br />");
		
		// 2. 向Session中存入信息
		session.setAttribute("name1", "tom");
		session.setAttribute("name2", "jerry");
		
		// 3. 会话的保留时间 (单位为秒 默认值是1800  =30分钟)
		session.setMaxInactiveInterval(60);
		
		// 用户如果30分钟没有重新访问服务器,session会自动删除
		
		// 4. 让会话失效(用于 用户登出)
		session.invalidate();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
