<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
</head>
<body>

<form action="reg2.do" method="post">
	<fieldset>
		<legend>用户注册</legend>
		用户名:<input  type="text" name="name" /><br>
		性别:
		<input  type="radio" name="sex" value="男"  checked  />男
		<input  type="radio" name="sex" value="女"   />女
		<br>
		年龄:<input  type="text" name="age" /><br>
		
		<button>注册</button>
		
	</fieldset>
</form>


</body>
</html>