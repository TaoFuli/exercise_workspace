package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfl.pojo.LeaveWord;
import com.tfl.service.UserService;
import com.tfl.service.UserServiceImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserService userservice=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String strid=req.getParameter("wid");
		int wid=Integer.parseInt(strid);
		LeaveWord leaveword=new LeaveWord();
		leaveword.setWid(wid);
		//调用业务处理
		boolean b=userservice.removeLeaveWord(leaveword);
		//判
		if(b)
		{
			resp.sendRedirect("search");
		}
		else
		{
			req.setAttribute("Err","删除失败！");
			req.getRequestDispatcher("search?p=${paging.currPage}").forward(req, resp);;
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
