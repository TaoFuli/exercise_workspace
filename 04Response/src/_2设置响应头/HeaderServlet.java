package _2设置响应头;

import java.io.PrintWriter;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 设置响应头
//		resp.addHeader("username", "qiang");
//		resp.addIntHeader("age", 18);
//		resp.setHeader("sex", "male");
//		resp.setDateHeader("birthday", new Date().getTime());
//		
		
		// 
		
		// 方式1 让客户端3秒跳转
		//resp.setHeader("refresh", "3;url=https://www.baidu.com");
		
		// 方式2 直接跳转
//		resp.setStatus(302);
//		resp.setHeader("location", "https://www.baidu.com");
		
		// 方式3 重定向
		resp.sendRedirect("https://www.baidu.com");
		
		
		pw.println("Hello world");
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
