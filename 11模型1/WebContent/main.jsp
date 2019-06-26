<%@page import="com.igeek.geekshop.domain.User"%>
<%@page import="com.igeek.geekshop.domain.Word"%>
<%@page import="java.util.List"%>
<%@page import="com.igeek.geekshop.dao.impl.WordDAOImpl"%>
<%@page import="com.igeek.geekshop.dao.IWordDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${user.username},欢迎光临

<%
	
	// 查询数据
	User user = (User)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("login.jsp");
		
	}
	else
	{
		IWordDAO dao = new WordDAOImpl();
		List<Word> list = dao.findAll(user.getId());
		pageContext.setAttribute("list", list);
	}
%>

<!-- 单词列表 -->
<h1>单词列表</h1>
<table border="1">
<tr><td>序号</td><td>单词</td><td>操作</td></tr>
<c:forEach var="word" items="${list}" >
	<tr>
	<td>${word.id}</td>
	<td>${word.word}</td>
	<td><a href="delWord.jsp?id=${word.id}">删除</a></td>
	</tr>
</c:forEach>
</table>

<h1>添加单词</h1>
<form action="addWord.jsp" method="get">
<input type="text" name="word" />
<input type="submit" value="添加" />
</form>

</body>
</html>