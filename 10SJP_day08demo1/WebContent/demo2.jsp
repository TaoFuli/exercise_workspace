<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式取得复杂的数据</title>
</head>

<%
		//在page作用域中存放了一个int数组
		pageContext.setAttribute("Arr", new int[]{1,2,3,4,5});
		
		//定义List集合
		List<String> mylist=new ArrayList<>();
		mylist.add("aa1");
		mylist.add("aa2");
		mylist.add("aa3");
		mylist.add("aa4");
		mylist.add("aa5");
		mylist.add("aa6");
		mylist.add("aa7");
		mylist.add("aa8");
		mylist.add("aa9");
		mylist.add("aa0");
		pageContext.setAttribute("NameList",mylist);
		
		//定义Map集合
		Map<String,String> myMap=new HashMap<>();
		myMap.put("userid", "1001");
		myMap.put("name","张三");
		myMap.put("sex","男");
		myMap.put("age","18");
		
		//存储到page作用域
		pageContext.setAttribute("UserMap", myMap);
		
		//存放User对象
		pageContext.setAttribute("MyUser", new com.tfl.pojo.User(1001,"username","loginName","zhangsan","男"));
		
		//变量的名称包含特殊符号
		pageContext.setAttribute("user-name.value", "22222");
			
%>
<body>
<h2>${NameList[1]}</h2>
<h2>${NameList.get(2)}</h2>

<h2>${NameList.add('97') }</h2>
<h2>${NameList.size()}</h2>
<h2>${NameList.add(1,'0000') }</h2>
<hr>
<!-- EL  访问对象  识别的   getter方法 -->
<h1>${MyUser.id}</h1>
<h2>${MyUser.getId() }</h2>
<h2>${MyUser['id'] }</h2>

<hr>
<h2>${pageScope["user-name.value"] }</h2>

</body>
</html>