package com.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		                                                                                            
		pw.println("<!DOCTYPE html>                                                                  "); 
		pw.println("<html>                                                                           "); 
		pw.println(" <head>                                                                           "); 
		pw.println("  <meta charset='UTF-8'>                                                           "); 
		pw.println("  <title>登录</title>                                                              "); 
		pw.println(" </head>                                                                          "); 
		pw.println("<body>                                                                           ");
		pw.println(" <h3>登录</h3>");
		pw.println(" <form action='loginCheck' method='get'>                                         "); 
		pw.println("  用户名：<input type='text' name='username' value='admin' /><br />                "); 
		pw.println("  密&nbsp;&nbsp;码：<input type='password' name='password' value='123' /><br />     "); 
		pw.println("  验证码：<input type='text' name='checkCode' />                                   "); 
		pw.println("  <img src='checkImage' id='checkImg'/>                                            "); 
		pw.println("  <script>                                                                         "); 
		pw.println("	document.getElementById('checkImg').onclick=function(){                      "); 
		pw.println("	var r=Math.random();                                                         "); 
		pw.println("	this.src='checkImage?'+r;                                                    "); 
		pw.println("	};                                                                           "); 
		pw.println("  </script><br/>                                                                   "); 
		pw.println("  <input type='submit' value='登录'/>                                              "); 
		pw.println("  <input type='button' onclick=\"window.open('register')\" name='register' value='注册' />                                             "); 
		pw.println(" </form>                                                                          "); 
		pw.println("</body>                                                                          "); 
		pw.println("</html>                                                                          ");
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
