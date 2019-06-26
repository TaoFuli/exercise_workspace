<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>数字格式化</h1>
	<fmt:formatNumber value="123123123.234234" maxIntegerDigits="7"
		maxFractionDigits="3" groupingUsed="true" var="num1" />
	${num1}
	<br />
	<fmt:formatNumber value="123123123.234234" pattern="#.##E0" var="num1" />
	${num1}
	<br />
	<h1>数字反格式化</h1>
	<fmt:parseNumber value="123,123,123.234,234" var="num1" />
	例子1:${num1}
	<br />
	<fmt:parseNumber value="1.23E6" pattern="#.##E0" var="num1" />
	例子2:${num1}
	<br />
	<fmt:parseNumber value="65%" pattern="00%" var="num1" />
	例子3:${num1}
	<br />
	<hr />
	<h1>日期格式化</h1>
	<%
		pageContext.setAttribute("date", new java.util.Date());
	%>
	<h2>日期对象 -> 指定格式的字符串</h2>
	<fmt:formatDate value="${date}" type="both" dateStyle="default"
		timeStyle="default" var="dateStr" />
	<h3>default:${dateStr}</h3>
	<fmt:formatDate value="${date}" type="both" dateStyle="short"
		timeStyle="short" var="dateStr" />
	<h3>short:${dateStr}</h3>
	<fmt:formatDate value="${date}" type="both" dateStyle="medium"
		timeStyle="medium" var="dateStr" />
	<h3>medium${dateStr}</h3>
	<fmt:formatDate value="${date}" type="both" dateStyle="long"
		timeStyle="long" var="dateStr" />
	<h3>long${dateStr}</h3>
	<fmt:formatDate value="${date}" type="both" dateStyle="full"
		timeStyle="full" var="dateStr" />
	<h3>full${dateStr}</h3>
	<fmt:formatDate value="${date}" type="both"
		pattern="yyyy年MM月dd日 HH时mm分ss秒SSS毫秒" var="dateStr" />
	<h3>自定义格式${dateStr}</h3>
	<fmt:formatDate value="${date}" type="time" timeStyle="short"
		var="dateStr" />
	<h3>时间:${dateStr}</h3>
	<fmt:formatDate value="${date}" type="date" dateStyle="short"
		var="dateStr" />
	<h3>时间:${dateStr}</h3>
	<hr />
	<h2>指定格式的字符串 -> 日期对象</h2>
	<fmt:parseDate value="2017年09月23日 10时15分26秒831毫秒" type="both"
		pattern="yyyy年MM月dd日 HH时mm分ss秒SSS毫秒" var="date" />
	<h3>${date}</h3>



	<hr />
	<h1>时区</h1>
	<fmt:setTimeZone value="GMT+6" />
	<%
		pageContext.setAttribute("date", new java.util.Date());
	%>
	<fmt:formatDate value="${date}" type="both" dateStyle="medium"
		timeStyle="medium" var="dateStr" />
	<h3>东六区:medium${dateStr}</h3>

	<fmt:timeZone value="ET">
		<fmt:formatDate value="${date}" type="both" dateStyle="medium"
			timeStyle="medium" var="dateStr" />
		<h3>美国东海岸:medium${dateStr}</h3>
	</fmt:timeZone>

	<hr />
	<table border="1">
		<tr><th>时区</th><th>时间</th></tr>
		<c:forEach var="zone"
			items="<%=java.util.TimeZone.getAvailableIDs()%>">
			<tr>
				<td><c:out value="${zone}"></c:out></td>
				<td><fmt:timeZone value="${zone}">
						<fmt:formatDate value="${date}" type="both" dateStyle="medium"
							timeStyle="medium" var="dateStr" />
						<h3>medium${dateStr}</h3>
					</fmt:timeZone></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>