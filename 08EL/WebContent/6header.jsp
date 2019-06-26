<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件类型:${header.accept}</h1>
<h1>语言和区域:${header["accept-language"]}</h1>
<h1>浏览器相关信息:${headerValues["user-agent"][0]}</h1>
<h1>压缩技术:${header["accept-encoding"]}</h1>
<h1>服务器信息:${header.host}</h1>
<h1>连接特性:${header.connection}</h1>
<h1>cookie信息:${header.cookie}</h1>

</body>
</html>