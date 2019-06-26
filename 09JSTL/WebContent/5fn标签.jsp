<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fn 函数</h1>
	<%
		pageContext.setAttribute("info", "无锡,iGeekHome,java");
	%>
	<h3>查找iGeekHome:${fn:contains(info,"iGeekHome")}</h3>
	<h3>查找iGeekHome部分大小写:${fn:containsIgnoreCase(info,"iGeekHome")}</h3>
	<h3>判断开头:${fn:startsWith(info,"无锡")}</h3>
	<h3>判断结尾:${fn:endsWith(info,"java")}</h3>
	<h3>查找位置:${fn:indexOf(info,"iGeekHome")}</h3>
	<h3>截取:${fn:substring(info,3,9)}</h3>
	<h3>替换:${fn:replace(info,"iGeekHome","极客营")}</h3>
	<h3>拆分:${fn:split(info,",")}</h3>
	
	
</body>
</html>