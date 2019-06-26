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

@WebServlet("/loginchk2")
public class LoginCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		// 1. 接收用户提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String checkCode = req.getParameter("checkCode");
		
		HttpSession s = req.getSession();
		
		// 比对用户输入的验证码是否正确
		String cCode = (String)s.getAttribute("checkcode");
		if(cCode==null || !checkCode.toLowerCase().equals(cCode.toLowerCase()))
		{
			pw.println("验证码出错,验证码已失效!");
			pw.println("<a href=\""+resp.encodeURL("login2")+"\">重新登录</a>");
			return;
		}
		
		// 2. 处理数据
		// 3. 返回信息
		resp.setContentType("text/html;charset=utf-8"); 
		if("admin".equals(username)&&"123".equals(password))
		{
			// 将用户的登录信息放在Session中
			s.setAttribute("username", username);
			
			// 使用Cookie保存用户名
			// 设置Cookie
//			Cookie c1 = new Cookie("username",username);
//			c1.setMaxAge(5*60);
//			resp.addCookie(c1);
			
			// 将JSESSIONID使用Cookie保存
			// 重新打开浏览器能保持之前的会话
//			Cookie c2 = new Cookie("JSESSIONID",s.getId());
//			c2.setMaxAge(1*60*6);
//			resp.addCookie(c2);
			
			resp.sendRedirect(resp.encodeURL("main2"));
		}
		else
		{
			resp.sendRedirect(resp.encodeURL("loginFail2"));
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
