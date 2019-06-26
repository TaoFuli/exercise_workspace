<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//1. 接收用户提交的参数
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	// 2. 处理数据
	// 3. 返回信息

	if ("admin".equals(username) && "123".equals(password)) {
		out.println("登录成功");
	} else {
		out.println("登录失败");
	}
%>