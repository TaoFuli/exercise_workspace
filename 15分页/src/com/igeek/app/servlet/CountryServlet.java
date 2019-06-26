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

import com.igeek.app.dao.ICountryDAO;
import com.igeek.app.dao.impl.CountryDAOImpl;
import com.igeek.app.pojo.Country;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;

import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 2. 查询数据
		ICountryDAO dao = new CountryDAOImpl();
		List<Country> list = null;
		try {
			list = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. 请求转发
		req.setAttribute("counties", list);
		System.out.println(list);
		req.getRequestDispatcher("/WEB-INF/country.jsp").forward(req,resp);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
