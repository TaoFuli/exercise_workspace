package _2设置响应头信息;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		//设置响应头
		resp.addHeader("username", "qiang");
		resp.addIntHeader("age", 18);
		resp.setHeader("sex", "male");
		resp.setDateHeader("birthday", new Date().getTime());
		
		//实现重定向
		//1.让客户端3秒后跳转
		//resp.setHeader("refersh","3;url=https://www.baidu.com");
		
		//2.直接跳转页面
		//resp.setStatus(302);
//		resp.setHeader("location", "https://www.baidu.com");
		
		//3.重定向
		//resp.sendRedirect("https://www.baidu.com");
		pw.println("Hello");
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
