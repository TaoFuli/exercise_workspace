package _4输出数据;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/WriterServlet")
public class WriterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>用户登录</h1>");
		pw.println("<form action=\"loginchk\" method=\"get\">");
		pw.println("<input type=\"text\" name=\"username\"><br>");
		pw.println("<input type=\"password\" name=\"password\"><br>");
		pw.println("<input type=\"submit\" value=\"提交\">");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
