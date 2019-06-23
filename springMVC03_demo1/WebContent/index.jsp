<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示商品页面</title>
</head>
<body>
<a href="show.action">显示所有商品</a>

<c:if test="${not empty ItemList}">

	<form action="show.action" method="get">
		<table style="align:center;width:80%;border:1px;">
			<thead>
				<tr>
					<td>选择商品</td>
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>创建时间</td>
					<td>商品评论</td>
				</tr>
			</thead>
			<c:forEach var="item" items="${ItemList}">
				<tr>
					<td><input type="checkbox" name="ids" value="${item.id}"/></td>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.createTime}</td>
					<td>${item.detail}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6"><button>删除</button></td>
			</tr>
		</table>
	</form>

</c:if>
</body>
</html>