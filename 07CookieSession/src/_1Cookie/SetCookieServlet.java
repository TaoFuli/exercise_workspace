package _1Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		//1.创建Cookie
		Cookie cookie1=new Cookie("username","192.168.3.1");
		Cookie cookie2=new Cookie("password","123456");
		
		//2.设定有效期
		cookie1.setMaxAge(1*60);//1分钟的有效时间
		cookie2.setMaxAge(1*60);
		
		cookie2.setMaxAge(0);//让Cookie失效
		cookie2.setMaxAge(-1);//让浏览器关闭时使Cookie失效
		
		//3.设置路径
//		cookie1.setPath("/");//整个服务器都有效
//		cookie1.setPath("/07CookieSession");//对于某个路径下有效
//		cookie2.setPath("/07CookieSession");//对于某个路径下有效
//		cookie1.setPath("/07CookieSession/admin");
		//4.添加到响应对象中
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
