package com.igeek.qshop.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.qshop.dao.IAdminDAO;
import com.igeek.qshop.dao.impl.AdminDAOImpl;
import com.igeek.qshop.pojo.Admin;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminLoginCHK")
public class AdminLoginCheckServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//1. 接收参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 2. 调用业务层方法处理
		IAdminDAO dao = new AdminDAOImpl();
		Admin user=null;
		try {
			user = dao.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. 显示结果
		HttpSession session = req.getSession();
		if (user != null) 
		{
			
			session.setAttribute("admin",user);
			
			// 跳转到首页
			resp.sendRedirect("admin");
		} else {
			// 方式1: 跳转
			session.setAttribute("errorInfo", "用户名密码不正确");
			resp.sendRedirect("adminLogin");
			
			// 方式2:请求转发 (可以传递信息信息)
			//req.setAttribute("errorInfo", "用户名密码不正确");
			//req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
