package _2ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet7
 */

public class HelloServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String shopName;
       String shopAdmin;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("doGet():Hello world7<br />网店名："+shopName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 @Override
	public void init(ServletConfig config) throws ServletException {
		shopName=config.getInitParameter(shopName);
		shopAdmin=config.getInitParameter(shopAdmin);
		System.out.println("初始化时候完成对变量shopName和shopAdmin的赋值");
		super.init(config);
	}

}
