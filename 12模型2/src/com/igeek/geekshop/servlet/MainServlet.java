package com.igeek.geekshop.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igeek.geekshop.dao.IWordDAO;
import com.igeek.geekshop.dao.impl.WordDAOImpl;
import com.igeek.geekshop.domain.User;
import com.igeek.geekshop.domain.Word;

import javax.servlet.annotation.WebServlet;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		// 1.  获取参数
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		// 2. 查询数据
		if(user==null)
		{
			resp.sendRedirect("login");
			return;
		}
		else
		{
			IWordDAO dao = new WordDAOImpl();
			List<Word> list=null;
			try {
				list = dao.findAll(user.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("list", list);
		}
		
		// 3. 请求转发
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
