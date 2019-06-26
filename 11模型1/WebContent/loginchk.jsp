<%@page import="com.igeek.geekshop.domain.User"%>
<%@page import="com.igeek.geekshop.dao.impl.UserDAOImpl"%>
<%@page import="com.igeek.geekshop.dao.IUserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//1. 接收参数
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// 2. 调用业务层方法处理
	IUserDAO dao = new UserDAOImpl();
	User user = dao.login(username, password);

	// 3. 显示结果
	if (user != null) 
	{
		session.setAttribute("user",user);
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>