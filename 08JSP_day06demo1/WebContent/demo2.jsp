<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="false"
    isELIgnored="false"
    buffer="8kb"
    
    autoFlush="true"
    isThreadSafe="true"
    session="true"
    extends="com.tfl.demo01.MyJSP"
    trimDirectiveWhitespaces="false"
    %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通过URL传递参数</title>
</head>
<body>
<a href="get.jsp?name=大帅哥" target="_blank">大帅哥</a>
<a href="get.jsp?name=小美女" target="_blank">小美女</a>
<a href="http://localhost:8080/08JSP_day06demo1/get.jsp?name=小姐姐" target="_blank">小姐姐</a>
<a href="/08JSP_day06demo1/get.jsp?name=小哥哥" target="_blank">小哥哥</a>
<a href="get.jsp?name=大哥哥" target="_blank">大哥哥</a>
</body>
</html>