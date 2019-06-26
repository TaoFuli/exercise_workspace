<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><a href="admin">返回管理员首页</a></h1>
<h1>${msg}</h1>
<c:remove var="msg" scope="session"></c:remove>

<!-- 单词列表 -->
<h1>商品列表</h1>
<table border="1">
<tr><td>序号</td><td>商品名</td><td>商品价格</td><td>商品图片</td><td>商品描述</td><td>商品分类</td><td>操作</td></tr>
<c:forEach var="g" items="${goods}" >
	
	<tr>
	<td>${g.id}</td>
	<td>${g.name}</td>
	<td>${g.price}</td>
	<td>${g.image}</td>
	<td>${g.description}</td>
	<td>${g.category_id}</td>
	<td><a href="adminDelGoods?id=${g.id}">删除</a></td>
	</tr>
</c:forEach>
</table>

<h1>添加分类</h1>
<form action="adminAddGoods" method="get">
商品名:<input type="text" name="name" /><br />
商品价格:<input type="text" name="price" /><br />
商品图片地址:<input type="text" name="image" /><br />
商品商品描述:<br />
<textarea rows="5" cols="20" name="description">商品描述</textarea><br />
<select name="category_id">
	<c:forEach var="category" items="${categorys}" >
		<option value="${category.id}">${category.name}</option>
	</c:forEach>	
</select><br />
<input type="submit" value="添加" />
</form>

</body>
</html>