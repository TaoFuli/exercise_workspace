package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.User;
import com.tfl.service.UserService;
import com.tfl.service.UserServiceImpl;

@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userservice=new UserServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String ctx=req.getParameter("context");
		HttpSession session=req.getSession();
		User u=(User)session.getAttribute("CurrUser");
		
		LeaveWord leaveword=new LeaveWord();
		leaveword.setFk_uloginName(u.getUloginName());
		leaveword.setWleaveWord(ctx);
		
		boolean b=userservice.insertByLeaveWord(leaveword);
		if(b)
		{
			resp.sendRedirect("search");
		}
		else
		{
			req.setAttribute("Err", "发布留言失败！");
			req.getRequestDispatcher("publish.jsp").forward(req, resp);;
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
