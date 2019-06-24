package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tfl.pojo.User;
import com.tfl.service.UserService;
import com.tfl.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service=new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		String checkCode=req.getParameter("checkCode");
		HttpSession session = req.getSession();
		String code=(String) session.getAttribute("checkCode");
		
		User user=service.selectByloginNameAndPassword(username, password);
		if(!code.equalsIgnoreCase(checkCode)){
//			pw.println("验证码不正确，请重新输入");
//			pw.println("<a href='login' >重新登录</a>");
//			pw.println("<script type='text/javascript'>confirm('验证码不正确，请重新输入。');</script>，我们现在去<a href='login.jsp'>登陆</a>。<a href='register'>注册</a>");
//			return;
			req.setAttribute("Err", "验证码错误！");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		if(user==null) 
		{
			req.setAttribute("Err", "用户名/密码错误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else
		{
			req.getSession().setAttribute("CurrUser", user);
			resp.sendRedirect("search");
		}
	}

}
