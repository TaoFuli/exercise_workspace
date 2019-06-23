package com.tfl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tfl.pojo.User;
import com.tfl.service.MessageService;
import com.tfl.service.MessageServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * 处理Post请求 
	 *  接收登录信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("UTF-8");
		//接收表单
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//调用业务
		User user = service.login(name, pwd);
		
		//判断登录
		if(null == user) {
			request.setAttribute("Err", "用户名/密码错误!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}else {
			//存入会话
			request.getSession().setAttribute("CurrUser", user);
			
			//重定向到 indexServlet
			response.sendRedirect("index");
		}
		
	}

}
