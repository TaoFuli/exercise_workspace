<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示所有商品</title>
</head>
<body>
	<a href="show.action">显示所有商品</a>
	
	<c:if test="${not empty ItemList}" >
	<table style="align:center; width:80%; border:1px;">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>添加时间</td>
			<td>评论</td>
		</tr>
		<c:forEach var="item" items="${ItemList}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.createTime}</td>
				<td>${item.detail}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>