package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfl.service.UserService;
import com.tfl.service.UserServiceImpl;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service=new UserServiceImpl();
	private int pageSize=3;
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		int currPage=1;
		try {
		currPage=Integer.parseInt(req.getParameter("p"));
		}catch(Exception e){}
		
		req.setAttribute("paging",service.selectByleaveWord(pageSize,currPage));
		req.getRequestDispatcher("search.jsp").forward(req, resp);;
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
