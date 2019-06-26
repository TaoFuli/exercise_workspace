package com.igeek.app.servlet;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tomcat.websocket.TransformationFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.igeek.app.dao.ICityDAO;
import com.igeek.app.dao.impl.CityDAOImpl;
import com.igeek.app.pojo.City;
import com.igeek.app.pojo.PageBean;
import com.igeek.app.service.CityService;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1.  获取参数
		String pageStr = req.getParameter("page");
		String countryCode = req.getParameter("code");
		
		int page = 1;
		if(pageStr!=null)
		{
			try 
			{
				page=Integer.parseInt(pageStr);
			}
			catch(Exception e)
			{	
			}
		}
		
		// 2.  查询数据
		CityService service = new CityService();
		PageBean<City> pageBean=null;
		if(countryCode!=null)
		{
			pageBean= service.findCountryCityByPage(countryCode,page);
		}
		else
		{
			pageBean= service.findCityByPage(page);
		}
		
		// 3. 请求转发
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("countryCode", countryCode);
		req.getRequestDispatcher("/WEB-INF/city.jsp").forward(req,resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
