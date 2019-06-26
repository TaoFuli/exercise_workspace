<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr><td>编号</td><td>城市</td><td>国家编号</td><td>地区</td><td>人口</td></tr>
	<c:forEach items="${pageBean.list}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.name}</td>
			<td>${c.countryCode}</td>
			<td>${c.district}</td>
			<td>${c.population}</td>
		</tr>
	</c:forEach>
</table>
<a href="city?code=${countryCode}&page=1"> &lt;&lt;</a>
&nbsp;
<c:choose>
	<c:when test="${pageBean.page==1}">
		&lt;
	</c:when>
	<c:otherwise>
		<a href="city?code=${countryCode}&page=${pageBean.page-1}">&lt; </a>
	</c:otherwise>
</c:choose>

<c:forEach begin="${pageBean.start}" end="${pageBean.end}" step="1" varStatus="status">
	<c:choose>
		<c:when test="${status.index==pageBean.page}">
			${status.index}
		</c:when>
		<c:otherwise>
			<a href="city?code=${countryCode}&page=${status.index}">${status.index}</a>&nbsp;
		</c:otherwise>
	</c:choose>
</c:forEach>
&nbsp;
${pageBean.page}/${pageBean.pageAllCount}
&nbsp;

<form action="city" style="display:inline-block">	
	<input type="hidden" name="code" value="${countryCode}" />
	<input type="text" name="page" size="3"/><input type="submit" value="跳转">
</form>
<c:choose>
	<c:when test="${pageBean.page==pageBean.pageAllCount}">&gt;</c:when>
	<c:otherwise>
		<a href="city?code=${countryCode}&page=${pageBean.page+1}">&gt;</a>
	</c:otherwise>
</c:choose>
&nbsp;
<a href="city?code=${countryCode}&page=${pageBean.pageAllCount}">&gt;&gt;</a>
</body>
</html>