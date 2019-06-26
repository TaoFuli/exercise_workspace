<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询天气</title>
</head>
<body>
<form action="weather" method="get">
城市<input type="text" name="city" value="无锡">
<select name="type">
	<option value="xml" selected="selected">xml</option>
	<option value="json">json</option> 
</select>
<input type="submit" value="查询" />
</form>
</body>
</html>