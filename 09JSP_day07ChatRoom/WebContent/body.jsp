<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tfl.pojo.*" %>

<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- 3秒一刷新  -->
		<meta  http-equiv="refresh" content="3" />
		<title></title>
		<style>
			.from{
				margin-right: 5px;
				font-weight: bold;
			}
			.to{
				margin-right: 5px;
				font-style: italic;
			}
			
		</style>

	</head>
	<body>
		<h1 style="text-align: center;">极客营50营聊天室--消息显示</h1>
		
		<%
		//添加到聊天信息的集合中
		List<Message> messages = (List<Message>)application.getAttribute("Messages");
		if(messages != null){
			for(Message m:messages){
				out.println(m.toString()+"<br />");
			}
		}
		%>
		
		<!-- <span>张三</span>对<span>李四</span>说:<span>xxxxxxx</span>	<br />
		<span>张三</span>对<span>李四</span>说:<span>xxxxxxx</span>	<br />
		<span>张三</span>对<span>李四</span>说:<span>xxxxxxx</span>	<br />		 -->
	</body>
</html>
