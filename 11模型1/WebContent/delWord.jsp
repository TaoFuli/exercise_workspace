<%@page import="com.igeek.geekshop.dao.impl.WordDAOImpl"%>
<%@page import="com.igeek.geekshop.dao.IWordDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	IWordDAO dao = new WordDAOImpl();
	dao.removeByID(Integer.parseInt(id));
	response.sendRedirect("main.jsp");
%>