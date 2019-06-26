package 作用1存取应用全局信息;

import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet2")
public class TestServlet2 extends HttpServlet {

	int count = 0;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		// 得到ServletContext对象
		ServletContext sc = getServletContext();
		// 
		pw.println("用户:"+sc.getAttribute("username")+"<br>");
		
		pw.println("访问计数"+(++count)+"<br>");
		
		
		// 全站统计
		Integer allCount = (Integer)sc.getAttribute("allCount");
		if(allCount==null) 
			allCount = 1;
		else 
			allCount++;
		sc.setAttribute("allCount", allCount);
		pw.println("全站 访问计数"+allCount);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
