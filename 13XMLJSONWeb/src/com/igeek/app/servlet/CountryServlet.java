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
		
		String type = req.getParameter("type");
		
		
		ICountryDAO dao = new CountryDAOImpl();
		List<Country> list = null;
		try {
			list = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if("xml".equals(type))
		{
			// 1.   创建一个工厂对象
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			// 2.   使用工厂对象创建一个DocumentBuilder
			DocumentBuilder db = null;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 3. 创建新的document
			Document doc = db.newDocument();
			
			// 4. 创建节点
			Element countries = doc.createElement("Countries");
			doc.appendChild(countries);
			
			for(Country c:list)
			{
				// 国家节点 
				Element country = doc.createElement("Country");
				countries.appendChild(country);
				
				// 添加子节点
				Element code = doc.createElement("code");
				code.setTextContent(c.getCode());
				Element name = doc.createElement("name");
				name.setTextContent(c.getName());
				Element capital = doc.createElement("capital");
				capital.setTextContent(""+c.getCapital());
				
				country.appendChild(code);
				country.appendChild(name);
				country.appendChild(capital);
			}
			
			// 生成xml
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = null;
			try {
				tf = tff.newTransformer();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tf.setOutputProperty(OutputKeys.INDENT,"yes");// 设置换行
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");  
			
			// 
			StreamResult sr = new StreamResult(new StringWriter());
			sr.setWriter(resp.getWriter());
			try {
				tf.transform(new DOMSource(doc), sr);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			JSONArray jsonArray = JSONArray.fromObject(list);
			pw.println(jsonArray.toString());
 		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
