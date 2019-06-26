package _3设置响应内容的编码;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		// 方式1:
		// 设置响应内容 MIME类型 和 编码方式
//		resp.setContentType("text/html;charset=utf-8");
		
		// 方式2:
		// 告诉客户端你准备采用哪一种编码方式
		resp.setHeader("content-type", "text/html;charset=utf-8");
		// 设置后面发送的内容采用utf-8
		resp.setCharacterEncoding("gbk");
	
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
