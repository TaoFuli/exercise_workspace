<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("name", "xiaoming");
%>

<h1>1. jsp脚本方式</h1>
名字为:<% 
		out.println(request.getAttribute("name"));
	%>

<h1>2. jsp表达式方式</h1>
名字为:<%= request.getAttribute("name") %>

<h1>3. EL表达式</h1>
名字为:${name}
</body>
</html>