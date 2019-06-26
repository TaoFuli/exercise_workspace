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

import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;

@WebServlet("/region")
public class RegionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 接受参数
		String parameter = req.getParameter("parentid");
		int parentid = 0;
		if(parameter!=null)
		{
			parentid = Integer.parseInt(parameter);
		}
		
		// 2. 查询数据
		IRegionDAO dao = new RegionDAOImpl();
		List<Region> result = null;
		try {
			result = dao.findAllByParentId(parentid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. 返回结果
		JSONArray json = JSONArray.fromObject(result);
		pw.println(json.toString());

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
