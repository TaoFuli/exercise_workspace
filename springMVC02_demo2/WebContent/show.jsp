<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show页</title>
</head>
<body>
<h2>${sessionScope.suibian}</h2>
<h2>${sessionScope.session}</h2>
<h2>Model</h2>
<h2>${requestScope.modelAttrName}</h2>
<h2>${requestScope.modelAttrAge}</h2>
<h2>ModelMap</h2>
<h2>${requestScope.modelMapValue}</h2>
<h2>Request</h2>
<h2>${requestScope.ResquestValueName}</h2>
</body>
</html>