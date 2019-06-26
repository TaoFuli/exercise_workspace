package com.igeek.app.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.app.dao.IRegionDAO;
import com.igeek.app.dao.impl.RegionDAOImpl;
import com.igeek.app.service.RegionService;

import javax.servlet.annotation.WebServlet;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 接收参数
		String city = req.getParameter("city");
		
		// 2. 
		RegionService dao = new RegionService();
		String result = dao.findCityByName(city);
		
		// 3.
		pw.print(result);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

