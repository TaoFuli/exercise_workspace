package 作用3获取WebContext下文件磁盘路径;


import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/GetFilePathServlet")
public class GetFilePathServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		
		ServletContext sc = getServletContext();
		String filePath = sc.getRealPath("/WEB-INF/2.txt");
		pw.println(filePath);
		
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		String line = null;
		while((line = reader.readLine()) != null){
			pw.println(line);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
