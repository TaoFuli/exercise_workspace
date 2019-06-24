<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		int []arr={11,22,33,44,55,66};
		pageContext.setAttribute("Arr", arr);

%>

<!-- 	使用forEach标签迭代
	var  临时的变量，接收每次从集合中取得值
	items 迭代的集合或数组
	begin 表示集合或数组开始的位置
	end  结束位置
	step  步长  默认为1
	varStatus  状态   -->
	
	<c:forEach var="i" items="${Arr}" begin="0" end="3" step="2"
	varStatus="ss">
		<h2>${ss.index}------${i}</h2>
	</c:forEach>
	
</body>
</html>