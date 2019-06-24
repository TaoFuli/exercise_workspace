package com.tfl.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetJSON
 */
@WebServlet("/getjson.do")
public class GetJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("[" + 
				"{\"id\":1001,\"username\":\"张三\",\"sex\":\"男\"}," + 
				"{\"id\":1002,\"username\":\"李四\",\"sex\":\"男\"}," + 
				"{\"id\":1003,\"username\":\"王五\",\"sex\":\"女\"}," + 
				"{\"id\":1004,\"username\":\"贾六\",\"sex\":\"男\"}" + 
				"]");
	}


}
