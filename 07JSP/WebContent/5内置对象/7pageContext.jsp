<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>1. 通过他获得其他对象</h1>
<%
out.println(pageContext.getSession().getAttribute("name"));
%>
<h1>2. 域对象</h1>
<%
	pageContext.setAttribute("username", "qiang");
	out.println(pageContext.getAttribute("username"));
%>

</body>
</html>