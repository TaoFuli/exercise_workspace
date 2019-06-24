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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userservice=new UserServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String strid=req.getParameter("wid");
		int id=Integer.parseInt(strid);
		//调用业务
		LeaveWord leaveWord=userservice.selectByWid(id);
		//存入响应作用域  request
		req.setAttribute("EditLeaveWord", leaveWord);
		//转发
		req.getRequestDispatcher("edit.jsp").forward(req, resp);;
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//接受修改的留言的参数
		String id=req.getParameter("id");
		String context=req.getParameter("context");
		
		//封装
		LeaveWord leaveword=new LeaveWord();
		leaveword.setWid(Integer.parseInt(id));
		leaveword.setWleaveWord(context);
		//调用业务处理
		boolean b=userservice.editLeaveWord(leaveword);
		//判
		if(b)
		{
			resp.sendRedirect("search");
		}
		else
		{
			req.setAttribute("Err", "修改留言失败！");
			req.getRequestDispatcher("edit.jsp").forward(req, resp);;
		}
	}

}
