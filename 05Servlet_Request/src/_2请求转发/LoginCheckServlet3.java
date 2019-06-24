package _2请求转发;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginCheckServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if("admin".equals(username)&&"123".equals(password))
		{
			req.getRequestDispatcher("/loginOK.html").forward(req, resp);
			req.getRequestDispatcher("/loginOK.html").include(req, resp);
		
			pw.println("<h1>输出一些当前Servlet中的内容</h1>");
			//.forword 只显示请求转发的页面
			//.include 包含请求转发的页面
		
		}
		
		else
		{
			req.getRequestDispatcher("loginFail.html").forward(req, resp);
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
