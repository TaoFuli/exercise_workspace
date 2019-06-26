<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>访问统计</h1>

<table border="1">
	<tr><td>ip</td><td>访问量</td></tr>
	<c:forEach items="${map}" var="v">
		<tr><td>${v.key}</td><td>${v.value}</td></tr>
	</c:forEach>
</table>
</body>
</html>