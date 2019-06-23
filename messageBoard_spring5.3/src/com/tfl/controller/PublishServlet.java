package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tfl.pojo.Message;
import com.tfl.pojo.User;
import com.tfl.service.MessageService;

@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//业务
		private  MessageService service ;
		/**
		 * 初始化方法
		 */
		@Override
		public void init(ServletConfig config) throws ServletException {
			//获取上下文对象
			ServletContext application =  config.getServletContext();
			service =  (MessageService)  application.getAttribute("service");
		}
	
	/**
	 * 处理Get请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/publish.jsp").forward(request, response);
	}

	/**
	 * 处理Post请求
	 *  
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("UTF-8");
		//接收表单
		String ctx = request.getParameter("context");
		//取得当前登录用户
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("CurrUser");
		
		//封装留言信息
		Message msg = new Message();
		msg.setAuthorId(u.getId());
		msg.setContext(ctx);
		
		//调用业务
		boolean b = service.publishMessage(msg);
		
		//判断
		if(b) {
			//成功 重定向到indexServlet
			response.sendRedirect("index");
		}else {
			//失败
			request.setAttribute("Err", "发布留言失败!");
			//转发到发布留言页面
			request.getRequestDispatcher("/WEB-INF/views/publish.jsp").forward(request, response);
		}
		
		
	}

}
