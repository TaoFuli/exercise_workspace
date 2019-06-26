<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. jsp方式显示内容</h1>
<%
	out.println("Hello world!");
%>
<h1>2. EL表达式</h1>
<%
	request.setAttribute("info","Hello world!");
%>
${info}
<h1>3. JSTL方式</h1>
<c:out value="${info}" />
</body>
</html>