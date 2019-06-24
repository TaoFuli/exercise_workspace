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

@WebServlet("/registerCheck")
public class RegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
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
			pw.println("<script type='text/javascript'>confirm('验证码不正确，请重新输入。');</script>，我们现在去<a href='login'>登陆</a>。继续<a href='register'>注册</a>");
			return;
		}
		
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
	
		// 调用Service登录方法
		UserService service = new UserService();
		
		if(service.register(user))
		{
//			pw.println("注册成功！");
			pw.println("<script type='text/javascript'>confirm('注册成功！');</script>");
			resp.sendRedirect("main");
		}
		else
		{
//			pw.println("注册失败！该用户已经存在");
//			pw.println("<a href='login'>登录</a>");
			pw.println("<script type='text/javascript'>confirm('注册失败!该用户已经注册。');</script>，我们现在去<a href='login'>登陆</a>。继续<a href='register'>注册</a>");
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
