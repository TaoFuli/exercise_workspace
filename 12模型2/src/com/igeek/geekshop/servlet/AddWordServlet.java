package com.igeek.geekshop.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.geekshop.dao.IWordDAO;
import com.igeek.geekshop.dao.impl.WordDAOImpl;
import com.igeek.geekshop.domain.User;

import javax.servlet.annotation.WebServlet;

@WebServlet("/addWord")
public class AddWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 获取参数
		String word = req.getParameter("word");
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		// 2. 调用DAO
		IWordDAO dao = new WordDAOImpl();
		try {
			dao.add(word, user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3. 跳转
		resp.sendRedirect("main");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
