package _1获取请求信息;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestRequestServlet")
public class TestRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		//1.请求行里的信息
		pw.println("<h1>1.请求行中的信息</h1>");
		pw.println("<br />Method:"+req.getMethod());
		pw.println("<br />URL:"+req.getRequestURL());
		pw.println("<br />路径："+req.getContextPath());
		pw.println("<br />服务器地址："+req.getLocalAddr());
		pw.println("<br />客户端地址："+req.getRemoteAddr());
		pw.println("<br />请求的参数字符串："+req.getQueryString());
		pw.println("<hr />");
		
		//2.请求头里的信息
		pw.println("<h1>2.请求头中的信息</h1>");
		pw.println("<br/>浏览器类型："+req.getHeader("User-Agent"));
		pw.println("<br />所有请求头信息：");
		Enumeration<String> keys = req.getHeaderNames();
		while(keys.hasMoreElements())
		{
			String key=keys.nextElement();
			pw.println("<br />"+key+":"+req.getHeader(key));
		}
		
		//3.用户提交的参数
		pw.println("<h1>3.用户提交的参数：</h1>");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String[] like=req.getParameterValues("like");
		pw.println("<br />username:"+username+"<br />password:"+password);
		pw.println("<br />爱好："+Arrays.toString(like));
		pw.println("<br />所有信息：");
		Map<String,String[]> infos=req.getParameterMap();
		for ( Entry<String, String[]> e : infos.entrySet()) {
			pw.println("<br />"+e.getKey()+":"+Arrays.toString(e.getValue()));
		}
		
		//4.也是域对象
		pw.println("<h1>4.是域对象：</h1>");
		req.setAttribute("age", 18);
		pw.println("<br />"+req.getAttribute("age"));
		req.removeAttribute("");
		pw.println("<br />"+req.getAttribute("age"));
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
