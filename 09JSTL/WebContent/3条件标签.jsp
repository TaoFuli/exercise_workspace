<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. if标签</h1>
<c:if test="${param.username=='admin'}" var="result" scope="page">
	xxx: ${result}<br/>
	欢迎光临管理员,${param.username}
</c:if>
<c:if test="${param.username!='admin'}" var="result" scope="page">
	yyy: ${result}<br/>
	欢迎光临用户,${param.username}
</c:if>

<h1>2. choose标签</h1>
<c:set var="city" value="shanghai" scope="page"></c:set>
<c:choose>
	<c:when test="${city=='shanghai'}">
		<h3>上海</h3>
	</c:when>
	<c:when test="${city=='wuxi'}">
		<h3>无锡</h3>
	</c:when>
	<c:when test="${city=='suzhou'}">
		<h3>苏州</h3>
	</c:when>
	<c:otherwise>
		<h3>其他城市</h3>
	</c:otherwise>
</c:choose>

<h1>3. 使用choose标签实现if-else</h1>
<c:choose>
	<c:when test="${param.username=='admin'}">
		管理员你好
	</c:when>
	<c:otherwise>
		普通用户你好
	</c:otherwise>
</c:choose>

</body>
</html>