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
<h1>商品分类列表</h1>
<table border="1">
<tr><td>序号</td><td>分类名</td><td>操作</td></tr>
<c:forEach var="category" items="${categorys}" >
	<tr>
	<td>${category.id}</td>
	<td>${category.name}</td>
	<td><a href="adminDelCategory?id=${category.id}">删除</a></td>
	</tr>
</c:forEach>
</table>

<h1>添加分类</h1>
<form action="adminAddCategory" method="get">
<input type="text" name="name" />
<input type="submit" value="添加" />
</form>

</body>
</html>