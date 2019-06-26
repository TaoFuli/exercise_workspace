<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. c:out</h1>
<%
	//pageContext.setAttribute("city","苏州");
%>
<c:out value="${city}" default="无锡" ></c:out>

<h1>2. c:set</h1>
<c:set var="city" value="苏州" scope="request"></c:set>
<c:out value="${city}" default="无锡" ></c:out>

<h1>3. c:remove</h1>
<c:remove var="city" scope="request"></c:remove>
<c:out value="${city}" default="无锡" ></c:out>

<h1>4. c:catch</h1>
<c:catch var="msg">
<%
	int reuslt = 10/0;
%>
</c:catch>
${msg}

</body>
</html>