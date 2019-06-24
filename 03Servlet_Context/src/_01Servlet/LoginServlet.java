package _01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.接收用户信息
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		//2.信息的处理
		
		//3.显示结果
		if("admin".equals(username) && "123".equals(password))
		{
			pw.println("登录成功！");
		}
		else
		{
			pw.println("登录失败！");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
