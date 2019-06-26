<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div class="easyui-window" title="管理员登录"
		style="width: 250px; height: 150px">
		
		<form action="adminLoginCHK" method="get">
			<table class="easyui-table">
				<tr><td>用户名:</td><td><input type="text" name="username" value="qiang"></td></tr>
				<tr><td>密码:</td><td><input type="password" name="password" value="654321"></td></tr>
				<tr><td colspan="2"><input type="submit" value="提交" style="width:220px;text-align:center"></td></tr>
				<tr><td colspan="2">${errorInfo}</td></tr>
			</table>
		</form>
	</div>
</body>
</html>