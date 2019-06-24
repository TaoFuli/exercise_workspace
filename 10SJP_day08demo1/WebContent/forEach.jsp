<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL核心标签库--条件标签 IF</title>
</head>
<body>
<c:set var="name" value="张三" />

<c:out value="${name}"/>
<c:if test="${name=='张三'}" var="i" scope="page">
	<h1>满足大于0 ${i}</h1>
</c:if>
<c:set var="age" value="10" />

<c:if test="${age<=10}">
<h3>你还小</h3>
</c:if>

<!-- EL表达式的运算符 empty
当变量不存在   返回true  变量存在，但是变量的值为null,返回true -->

<h2>name=${empty name}</h2>
<c:if test="${empty name}">
	<h3>name 变量为空</h3>
</c:if>

<!-- 特殊的test条件   字符串 -->
<c:if test="1111">
	<h3>1111</h3>
</c:if>

<c:if test="false">
	<h3>false</h3>
</c:if>
<c:if test="true">
	<h3>true</h3>
</c:if>

</body>
</html>