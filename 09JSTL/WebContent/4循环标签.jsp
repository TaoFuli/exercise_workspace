<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. forEach</h1>
<h3>例子1. 从1输出到10</h3>
<c:forEach begin="1" end="10" step="1" varStatus="status">
	${status.index}<br />
</c:forEach>

<h3>例子2. 迭代数组 </h3>
<%
	String[] cities = {"苏州","无锡","常州","上海"};
	pageContext.setAttribute("cities",cities);
%>

<c:forEach var="city" items="${cities}">
	${city}<br />
</c:forEach>
<h3>例子3. 迭代集合容器 </h3>
<%
	List<String> cities2 = new ArrayList<>();
	cities2.add("苏州");
	cities2.add("常州");
	cities2.add("无锡");
	pageContext.setAttribute("cities2",cities2);
%>
<c:forEach var="city" items="${cities2}">
	${city}<br />
</c:forEach>

<h3>例子4: </h3>
<!--
	varStatus 接收循环状态的变量
		index 元素的下标
		count 已遍历的个数
		first 当前元素是否是第一个
		last  当前元素是否是最后一个
		current 当前对象	
 -->
 
 <c:forEach var="city" items="${cities}" varStatus="status">
 	<c:out value="${status.index}"></c:out>&nbsp;
 	<c:out value="${status.count}"></c:out>&nbsp;
 	<c:out value="${status.first}"></c:out>&nbsp;
 	<c:out value="${status.last}"></c:out>&nbsp;
 	<c:out value="${status.current}"></c:out>&nbsp;<br />
 </c:forEach> 
 
<h1>2. forTokens</h1>
<%
	pageContext.setAttribute("languages", "c++,c#,python,Java,Javascript,VB,Swift,Lua");
%>
<c:forTokens items="${languages}" delims="," var="lang">
	${lang}<br />
</c:forTokens>
</body>
</html>