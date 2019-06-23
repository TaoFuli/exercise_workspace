<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试传递List</title>
</head>
<body>
<form action="delete3.action" method="post">
	<input type="text" name="myids[0]" value="1001"/><br/>
	<input type="text" name="myids[1]" value="1001"/><br/>
	<input type="text" name="myids[2]" value="1001"/><br/>
	<input type="text" name="myids[3]" value="1001"/><br/>
	<button>删除</button>
</form>
</body>
</html>