package com.igeek.app.servlet;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.igeek.app.dao.IRegionDAO;
import com.igeek.app.dao.impl.RegionDAOImpl;
import com.igeek.app.pojo.Region;
import com.igeek.app.service.RegionService;

import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;

@WebServlet("/searchHelp")
public class SearchHelpServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 接收参数
		String city = req.getParameter("city");
		
		// 2. 
		IRegionDAO dao = new RegionDAOImpl();
		List<Region> list = null;
		try {
			list = dao.findAllByName(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3.
		JSONArray json = JSONArray.fromObject(list);
		pw.print(json.toString());
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
