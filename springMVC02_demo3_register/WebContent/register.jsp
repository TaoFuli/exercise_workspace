<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>

<form action="reg.do" method="post">
	<fieldset>
		<legend>用户注册</legend>
		用户名:<input  type="text" name="username" /><br>
		登录名:<input  type="text" name="loginName" /><br>
		密码:<input  type="text" name="password" /><br>
		性别:
		<input  type="radio" name="sex" value="男"  checked  />男
		<input  type="radio" name="sex" value="女"   />女
		<br>
		出生日期：<input type="date" name="birthday"/><br/>
		Email:<input type="email" name="email" /><br>
		
		<button>注册</button>
		
	</fieldset>
</form>


</body>
</html>