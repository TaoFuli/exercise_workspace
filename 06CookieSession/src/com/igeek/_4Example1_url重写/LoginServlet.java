package com.igeek._4Example1_url重写;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login2")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		ShowSessionUtils.showSessionInfo(req, pw);
		
		pw.println("<h1>用户登录</h1>");
		pw.println("<form action=\""+resp.encodeURL("loginchk2")+"\" method=\"get\">");
		
		String username = "";
		Cookie[] cookies = req.getCookies();
		if(cookies!=null)
		{
			for(Cookie c:cookies)
			{
				if(c.getName().equals("username"))
				{
					username = c.getValue();
				}
			}
		}
		
		pw.println("<input type=\"text\" name=\"username\" value="+username+"><br>");
		pw.println("<input type=\"password\" name=\"password\"><br>");
		pw.println("<input type=\"text\" name=\"checkCode\"><br>");
		pw.println("<img src=\""+resp.encodeURL("checkImage2")+"\" width=\"100\" height=\"30\" onclick=\"javascript:this.src='"+resp.encodeURL("checkImage2?tm='+Math.random()")+"\" /><br />");
		pw.println("<input type=\"submit\" value=\"提交\">");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
