package _请求转发;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/loginchk3")
public class LoginCheckServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 接收用户提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 2. 处理数据
		// 3. 返回信息
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		if ("admin".equals(username) && "123".equals(password)) {
			req.getRequestDispatcher("/loginSuccess.html").forward(req, resp);
		} else {
			req.getRequestDispatcher("/loginFail.html").include(req, resp);
		}
		
		// 请求转发的2个方法
		// .forward	 		
		// .include		当前Servlet也能对输出流对象输出内容
		
		
		pw.println("<h1>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
