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
import com.shop.service.UserService;

@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String checkCode=req.getParameter("checkCode");
		
		HttpSession session = req.getSession();
		String code=(String) session.getAttribute("checkCode");
//		if(code==null) {
//			pw.println("验证码失效，请重新输入");
//			pw.println("<a href='login' >重新登录</a>");
//			return;
//		}
		if(!code.equalsIgnoreCase(checkCode)){
//			pw.println("验证码不正确，请重新输入");
//			pw.println("<a href='login' >重新登录</a>");
			pw.println("<script type='text/javascript'>confirm('验证码不正确，请重新输入。');</script>，我们现在去<a href='login'>登陆</a>。<a href='register'>注册</a>");
			return;
		}
		// 调用Service登录方法
		UserService service = new UserService();
		User user = service.login(username, password);
		if(user!=null) 
		{
			session.setAttribute("user", user);
			resp.sendRedirect("main");
//			resp.sendRedirect("loginOK");
		}
		else
		{
//			resp.sendRedirect("loginFail");
			pw.println("<script type='text/javascript'>confirm('登录失败!请核对用户名和密码。');</script>，我们现在去<a href='login'>登陆</a>。<a href='register'>注册</a>");
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
