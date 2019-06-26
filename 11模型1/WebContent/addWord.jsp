<%@page import="com.igeek.geekshop.dao.impl.WordDAOImpl"%>
<%@page import="com.igeek.geekshop.domain.User"%>
<%@page import="com.igeek.geekshop.dao.IWordDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 1. 获取参数
	String word = request.getParameter("word");
	User user = (User)session.getAttribute("user");
	// 2. 调用DAO
	IWordDAO dao = new WordDAOImpl();
	dao.add(word, user.getId());
	// 3. 跳转
	response.sendRedirect("main.jsp");
%>