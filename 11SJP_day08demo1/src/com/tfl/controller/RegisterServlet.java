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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userservice=new UserServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String checkCode=req.getParameter("checkCode");
		
		HttpSession session=req.getSession();
		String code = (String)session.getAttribute("checkCode");
		if(!code.equalsIgnoreCase(checkCode)){
//			pw.println("验证码不正确，请重新输入");
//			pw.println("<a href='login' >重新登录</a>");
//			pw.println("<script type='text/javascript'>confirm('验证码不正确，请重新输入。');</script>，我们现在去<a href='login.jsp'>登陆</a>。<a href='register'>注册</a>");
//			return;
			req.setAttribute("Err", "验证码错误！");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
		
		//设置编码防止获取到乱码
		req.setCharacterEncoding("utf-8");
		String username=req.getParameter("username");
		String uloginName=req.getParameter("uloginName");
		String upassword=req.getParameter("upassword");
		String usex=req.getParameter("usex");
		String ubirthday=req.getParameter("ubirthday");
		String uemail=req.getParameter("uemail");
		User user=new User();
		user.setUsername(username);user.setUloginName(uloginName);
		user.setUpassword(upassword);user.setUsex(usex);
		user.setUbirthday(ubirthday);user.setUemail(uemail);
		
		
		if(userservice.insertByUser(user))
		{
			req.setAttribute("CurrUser", user);
			resp.sendRedirect("search");
		}
		else
		{
			req.setAttribute("Err", "服务器吃代码太多啦！请重新注册！");
			req.getRequestDispatcher("register.jsp");
		}
		

		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
