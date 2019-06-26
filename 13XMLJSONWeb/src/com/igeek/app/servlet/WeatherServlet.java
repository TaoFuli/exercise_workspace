package com.igeek.app.servlet;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 获取参数
		String city = req.getParameter("city");
		String type = req.getParameter("type");
		
		// 2.
		
		
		// 2.1 获取网络数据
		String urlStr = "http://v.juhe.cn/weather/index?cityname="+city+"&dtype="+type+"&format=2&key=c32691b0071866c00aadcf2a0dfb648e";

		
		// 2.2 解析数据
		// xml
		if("xml".equals(type))
		{
			// 1.   创建一个工厂对象
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			// 2.   使用工厂对象创建一个DocumentBuilder
			DocumentBuilder db = null;;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// 3. 读取解析xml
			Document doc = null;
			try {
				doc = db.parse(urlStr);
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// 4. 从文档中获取节点
			
			
			pw.println(city+"今天的天气:<br />");
			NodeList nl1 = doc.getElementsByTagName("today");
			Element today = (Element)nl1.item(0);
			System.out.println(today);
			
			NodeList nl = today.getChildNodes(); 
			for(int i=0;i<nl.getLength();i++)
			{
				
				Element e = (Element)nl.item(i);
				System.out.println(e);
				if(e.getNodeName().equals("temperature"))
				{
					pw.println("气温"+e.getTextContent()+"<br />");
				}
				else if(e.getNodeName().equals("weather"))
				{
					pw.println("天气"+e.getTextContent()+"<br />");
				}
			}
			
		}
		else 
		{
			
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// 得到连接的输入流
			InputStream is = con.getInputStream();
			// 把网络读取到数据,先放入一个字节数组输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=is.read(buf))!=-1)
			{
				bos.write(buf,0,len);
			}
			bos.close();
			String result =  new String(bos.toByteArray(),"utf-8");
			System.out.println(result);
			
			// 解析
			JSONObject rootJson = JSONObject.fromObject(result);
			JSONObject resultJson = rootJson.getJSONObject("result");
			JSONObject todayJson = resultJson.getJSONObject("today");
			pw.println(city+"今天的天气<br />");
			pw.println("气温"+todayJson.getString("temperature"));
			pw.println("天气"+todayJson.getString("weather"));
			
			
		}
		
		// 3. 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

