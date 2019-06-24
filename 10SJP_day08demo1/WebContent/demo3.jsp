<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式的运算符</title>
</head>
<body>
<h3>1+2=${1+2}</h3>
<h3>1-2=${1-2}</h3>
<h3>1*2=${1*2}</h3>
<h3>1/2=${1/2}</h3>
<h3>1%2=${1%2}</h3>

<%-- <h3>1 div 2=${1 div 2}</h3> --%>
<%-- <h3>1 mod 2=${1 mod 2}</h3> --%>
<h3><%='a'+'b' %></h3>
<h3><%="a"+"b" %></h3>

<!-- EL表达式中+没有字符串拼接，尝试转换为数值类型 -->
<%-- <h3>${='a'+'b'}</h3>没有 --%>

<hr>
<h2>EL表达式的   关系运算符  操作是数值，返回的值是boolean</h2>
<h3>2>5=${2>5}</h3>
<h3>2 gt 5 =${2 gt 5}</h3>

<!-- <h3>2<5=${2<5} </h3> -->
<h3>2 lt 5=${2 lt 5 }</h3>

<h3>2>=5${2>=5}</h3>
<h3>2 ge 5${2 ge 5}</h3>

<h3>2<=5=${2<=5}</h3>
<h3>2 le 5=${2 le 5}</h3>

<h3>2==5=${2==5}</h3>
<h3>2 eq 5=${2 eq 5}</h3>

<h3>2 != 5 = ${2 != 5}</h3>
<%-- <h3>2 not eq 5 =${2 ne 5 }</h3> --%>

<h1>EL表达式的 逻辑运算符     操作是boolean值，返回的值boolean</h1>
<h3>true && true = ${true && true} </h3>
<h3>true && false = ${true && false} </h3>
<h3>false && true = ${false && true} </h3>
<h3>false && false = ${false && false} </h3>

<h3>true and true = ${true and true} </h3>

<%-- <h3>false & false = ${false & false} </h3> 错误 --%>


<h3>true || true = ${true || true} </h3>
<h3>true || false = ${true || false} </h3>
<h3>false || true = ${false || true} </h3>
<h3>false || false = ${false || false} </h3>

<h3>true or true = ${true or true} </h3>

<h3>! true = ${! true} </h3>
<h3>! false = ${! false} </h3>
<h3>not false = ${not false} </h3>
<h3>not true = ${not true} </h3>

<hr>
<h1>EL表达式的 三元运算符</h1>
<h3> 1+2>3?"呵呵":"哈哈" = ${1+2>3?"呵呵":"哈哈" } </h3>
</body>
</html>