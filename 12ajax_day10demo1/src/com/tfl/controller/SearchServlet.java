package com.tfl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tfl.dao.Dao;
import com.tfl.pojo.LeaveWord;

import flexjson.JSONSerializer;

/**
 * 搜索返回json
 */
@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Dao dao=new Dao();
	/**
	 * 接收
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //接收参数
		String queryString = request.getParameter("queryString");
		queryString=queryString==null?"":queryString;
		
		//调用dao
		List<LeaveWord>  list =  dao.select(queryString);
		
		//转换为json
		String json = new JSONSerializer().serialize(list);
		
		//设置输出格式
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
