package com.igeek._1Cookie;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		// 1. 创建Cookie对象
		Cookie c1 = new Cookie("username","xiaoming");
		Cookie c2 = new Cookie("name2","value2");
		Cookie c3 = new Cookie("name3","value3");
		
		// 2. 设置有效期  (单位为秒)
//		c1.setMaxAge(30*24*60*60);// 一个月
		c1.setMaxAge(3*60);//
		c2.setMaxAge(3*60);//
		c3.setMaxAge(3*60);//
//		c1.setMaxAge(0);// 让Cookie失效
//		c1.setMaxAge(-1);// 浏览器关闭的时候失效
		
		// 3. 设置路径
		//c1.setPath("/"); //整个服务器有效
		c1.setPath("/06CookieSession"); // 某个路径下有效
		c2.setPath("/06CookieSession");
		c3.setPath("/06CookieSession");
		
		// 4. 添加到response对象中
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		
		pw.println("设置Cookie");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
