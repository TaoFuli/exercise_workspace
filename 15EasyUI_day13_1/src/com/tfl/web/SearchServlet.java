package com.tfl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.Paging;
import com.tfl.service.UserService;
import com.tfl.service.UserServiceImpl;

import flexjson.JSONSerializer;

@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService service=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// TODO Auto-generated method stub
		int currPage=1;
		int pageSize=3;
		try {
		currPage=Integer.parseInt(req.getParameter("page"));
		pageSize=Integer.parseInt(req.getParameter("rows"));
		}catch(Exception e) {}
		
		//设置输出格式
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Paging<LeaveWord> pp=service.search(pageSize,currPage);
		Map<String,Object> map=new HashMap<>();
		map.put("total", pp.getRowsCount());
		map.put("rows", pp.getData());
		
		JSONSerializer s=new JSONSerializer().include("rows");
		out.print(s.serialize(map));
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
