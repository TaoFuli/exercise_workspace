package com.tfl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tfl.service.MessageService;
import com.tfl.service.MessageServiceImpl;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//业务
	private  MessageService service ;
	/**
	 * 初始化方法
	 */
	@Override
	public void init() throws ServletException {
		WebApplicationContext applicationContext =WebApplicationContextUtils.
				getWebApplicationContext(this.getServletContext());
		service = (MessageService)applicationContext.getBean("service");
	}

	/**
	 * 处理Get请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接收 要删除的 留言的id
		String str_id = request.getParameter("id");
		
		int id = Integer.parseInt(str_id);
		
		//调用业务
		boolean b = service.deleteMessageById(id);
		
		//判断
		if(b) {
			//成功 重定向到indexServlet
			response.sendRedirect("index");
		}
		/*else {
			//失败
			request.setAttribute("Err", "发布留言失败!");
			//转发到发布留言页面
			request.getRequestDispatcher("/publish.jsp").forward(request, response);
		}*/
		
	}


}
