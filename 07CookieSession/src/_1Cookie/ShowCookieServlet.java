package _1Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowCookieServlet")
public class ShowCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		Cookie[] cookies=req.getCookies();
		pw.println("<h1>Cookie信息</h1>");
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				Cookie c=cookies[i];
				pw.println(c.getName()+":"+c.getValue()+"<br />");
			}
		}
		else
		{
			pw.println("没有足够的Cookie信息");
		}
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
