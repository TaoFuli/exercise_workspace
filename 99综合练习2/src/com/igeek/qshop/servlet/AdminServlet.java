package com.igeek.qshop.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.qshop.dao.ICategoryDAO;
import com.igeek.qshop.dao.impl.CategoryDAOImpl;
import com.igeek.qshop.pojo.Admin;
import com.igeek.qshop.pojo.Category;

import javax.servlet.annotation.WebServlet;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 查询分类信息
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		
		if(admin == null)
		{
			resp.sendRedirect("adminLogin");
			return;
		}
		else
		{
			// 请求转发
			req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
		}
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

