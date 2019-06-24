<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- 5秒一刷新  -->
		<meta  http-equiv="refresh" content="5" />
		<title></title>
		
	</head>
	
	<%
		//取得在线人员列表
		List<String> onlineUsers = (List<String>)application.getAttribute("OnLines");
	%>
	
	<body>
		<h3 style="text-align: center;">在线人员列表</h3>
		
		<%
		  if(onlineUsers != null){
			  for(String u : onlineUsers){
				  out.println("<span>"+u+"</span><br />");
			  }
		}
		%>
		
		<!-- <span>张三</span><br />
		<span>张三</span>	<br />
		<span>张三</span><br />		 -->
	</body>
</html>
