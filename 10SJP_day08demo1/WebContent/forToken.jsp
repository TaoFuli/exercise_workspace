<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL核心标签库--迭代标签  ForTokens</title>
</head>
<body>
	<c:set var="names" value="张三,李四#王五%贾六&田七"/>
	<!-- forTokens 迭代字符串，类似spli()字符串拆分
		var 临时的变量，接收每次的取值结果
		items  迭代的字符串
		delims  按照什么字符串进行拆分
		begin  表示集合或者数组，的那个索引位置开始，0表示第一个元素
		end  结束位置
		step  步长  默认为1
		varStatus  状态  取得迭代的顺序的值 
		-->
	<c:forTokens var="s" items="${names}" delims=",#%&" >
		<h2>${s}</h2>
	</c:forTokens>
</body>
</html>