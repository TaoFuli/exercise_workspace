package com.igeek._4ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet8 extends HttpServlet {
	
	String shopName = null;
	String shopAdmin = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("网店名称:"+config.getInitParameter("shopName"));
		System.out.println("网店管理员:"+config.getInitParameter("shopAdmin"));
		shopName = config.getInitParameter("shopName");
		shopAdmin = config.getInitParameter("shopAdmin");
		
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.println("网店名称:"+shopName);
		pw.println("网店的管理员"+shopAdmin);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

