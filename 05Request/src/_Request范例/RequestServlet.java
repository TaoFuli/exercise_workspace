package _Request范例;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import javax.servlet.annotation.WebServlet;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 1. 请求行
		
		pw.println("<h1>1 请求行</h1>");
		pw.println("Method:"+req.getMethod()+"<br />");
		pw.println("RUI:"+req.getRequestURI()+"<br />");
		pw.println("URL:"+req.getRequestURL()+"<br />");
		pw.println("路径:"+req.getContextPath()+"<br />");
		pw.println("服务器地址:"+req.getRemoteAddr()+"<br />");
		pw.println("<hr />");
		// 2. 请求头
		pw.println("<h1>2 请求头</h1>");
		pw.println("浏览器类型:"+req.getHeader("User-Agent")+"<br />");

		
		
		// 得到所有请求头信息
		Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements())
		{
			String name = names.nextElement();
			pw.println(name+":"+req.getHeader(name)+"<br />");
		}
			
		pw.println("<hr />");
		// 3 Request 也是域对象 可以存放信息
		pw.println("<h1> 3 Request 也是域对象 可以存放信息</h1>");
		req.setAttribute("username", "qiang");
		pw.println(req.getAttribute("username")+"<br />");
		req.removeAttribute("username");
		pw.println(req.getAttribute("username")+"<br />");
		
		pw.println("<hr />");
		// 4. 获取用户参数
		pw.println("<h1> 4 获取用户参数</h1>");;
//		String name = req.getParameter("name");
//		String age = req.getParameter("age");
//		String[] likes = req.getParameterValues("likes");
//		pw.println("name="+name+"<br />");
//		pw.println("age="+age+"<br />");
//		pw.println("likes="+Arrays.toString(likes)+"<br />");
		
		Map<String,String[]> maps = req.getParameterMap();
		for(String key:maps.keySet())
		{
			pw.println(key+":"+maps.get(key)+"<br />");
		}
		
		pw.println("<hr />");
		// 应用1: 判断客户端浏览器类型
		
		// Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36
		// Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko
		// Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0

		pw.println("<h1>应用1: 判断客户端浏览器类型</h1>");
		if (req.getHeader("User-Agent").contains("Trident"))
		{
			pw.println("IE浏览器"+"<br />");
		}
		else if (req.getHeader("User-Agent").contains("Firefox")) 
		{
			pw.println("火狐浏览器"+"<br />");
		} else {
			pw.println("谷歌浏览器"+"<br />");
		}

		pw.println("<hr />");
		// 应用2:
		// 头中referer属性 判断盗链
		
		pw.println("<h1>应用2: 通过referer判断盗链</h1>");
		String referer = req.getHeader("referer");
		pw.println("referer:"+referer+"</br>");
		
		if(referer==null)
		{
			pw.println("非跳转,使用户直接打开的,不是盗链");
		}
		else
		{
			if(referer.indexOf("http://localhost:6080/05Request/") != -1)
			{
				pw.println("本站的其他页面跳转");
			}
			else
			{
				pw.println("盗链");
			}
		}
		
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
