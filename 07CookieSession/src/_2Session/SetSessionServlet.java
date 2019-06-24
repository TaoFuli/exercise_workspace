package _2Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("Hello");
		
		//1.得到Session对象
		HttpSession session = req.getSession();
		pw.println("SessionId:"+session.getId());
		
		//2.存入信息
		session.setAttribute("name1", "tom");
		session.setAttribute("name2", "jerry");
		session.setAttribute("name1", "123");
		
		//设定失效期
		//3.会话的保持时间
		session.setMaxInactiveInterval(30);//设置30秒后失效
		
		//4.让会话失效（如：用户登出）
//		session.invalidate();
		
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
