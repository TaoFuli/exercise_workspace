<%@ page  contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>极客营50营聊天室</title>
	</head>
	
	<!--
		框架页
		  rows 按照行拆分
		  cols 按照列拆分
	-->
	<frameset rows="80%,*">
		<frameset cols="80%,*">
			<frame src="body.jsp" />
			<frame src="online.jsp" />
		</frameset>	
		<frame src="send.jsp" />
	</frameset>
	
	<noframes>
	<body>
	</body>
	</noframes>
</html>
