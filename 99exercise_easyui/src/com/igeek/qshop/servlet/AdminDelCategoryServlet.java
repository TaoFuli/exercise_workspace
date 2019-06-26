package com.igeek.qshop.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;

import com.igeek.qshop.dao.ICategoryDAO;
import com.igeek.qshop.dao.impl.CategoryDAOImpl;

import junit.framework.TestCase;

import javax.servlet.annotation.WebServlet;

@WebServlet("/adminDelCategory")
public class AdminDelCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 获取参数
		String id = req.getParameter("id");
		
		// 2. 调用
		ICategoryDAO dao = new CategoryDAOImpl();
		boolean result = false;
		String msg = "";
		try {
			result = dao.removeByID(Integer.parseInt(id));
			System.out.println(result);
			if(result)
			{
				msg = "删除分类成功";
			}
			else
			{
				msg = "删除分类失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "删除失败"+e.getMessage();
		}

		// 3. 请求转发或重定向
		// 3. 请求转发或重定向
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		resp.sendRedirect("adminCategory");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
