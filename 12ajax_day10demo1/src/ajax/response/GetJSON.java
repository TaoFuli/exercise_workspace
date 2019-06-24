package ajax.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getjson.do")
public class GetJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("["
				+ "{\"id\":1001,\"user\":\"张三\",\"sex\":\"男\"},"
				+"{\"id\":1002,\"user\":\"李四\",\"sex\":\"男\"},"
				+"{\"id\":1003,\"user\":\"王五\",\"sex\":\"女\"},"
				+ "{\"id\":1004,\"user\":\"贾六\",\"sex\":\"男\"}]");
		
		
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
