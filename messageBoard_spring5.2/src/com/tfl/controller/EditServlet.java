package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tfl.pojo.Message;
import com.tfl.service.MessageService;
import com.tfl.service.MessageServiceImpl;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//依赖业务
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
	 * 处理Get请求 ，接收一个id 查找到要修改的 留言
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String str_id = request.getParameter("id");
		int id = Integer.parseInt(str_id);
		
		//调用业务
		Message message = service.searchMessageById(id);
		
		//存入作用域
		request.setAttribute("EditMessage", message);
		
		//转发
		request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
		
	}

	/**
	 * 处理Post请求 ，接收修改留言
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("UTF-8");
		//接受修改的留言的参数
		String id = request.getParameter("id");
		String context = request.getParameter("context");
		
		//封装
		Message msg = new Message();
		msg.setId(Integer.parseInt(id));
		msg.setContext(context);
		
		//调用业务
		boolean b = service.editMessage(msg);
		
		//判断
		if(b) {
			//成功 重定向到indexServlet
			response.sendRedirect("index");
		}else {
			request.setAttribute("Err","修改留言失败!");
			request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
		}
		
	}

}
