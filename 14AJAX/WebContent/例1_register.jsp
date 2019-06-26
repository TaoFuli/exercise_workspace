<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

	var xmlHttpReq;

	function checkName()
	{
		console.log("检测用户名是否已被注册");
		
		// 1. 得到用户输入的用户名
		var username = document.getElementById("username").value;
		
		// 2. 将用户名发送到服务器检测
		// 2.1 创建xmlHttpRequest对象
		createXmlHttpRequest();
		
		// 2.2  设定准备状态改变时回调的函数名  
		xmlHttpReq.onreadystatechange = handle;
		
		// 2.3 发出请求
		var url = "check?username=" + username;
		
		xmlHttpReq.open("get", url, true);
		// true 	采用异步     发请求后不等数据回来,继续往下运行,不会卡住界面      如果数据回来了,调用回到函数处理 
		// false       同步   发请求后一直等数据回来,后处理,再继续运行其他
		//向服务器发送请求  
		xmlHttpReq.send(null);
		
		console.log("xxxx");

	}

	function createXmlHttpRequest() 
	{
		if (window.XMLHttpRequest) {
			xmlHttpReq = new XMLHttpRequest();//非IE浏览器  
		} else {
			xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器  
		}
	}


	//状态发生改变时回调的函数  
	function handle() {
		console.log("xmlHttpReq请求状态:"+xmlHttpReq.readyState);
		//状态是0~4,4 为准备状态,表示已经获取到数据  
		if (xmlHttpReq.readyState == 4) {
			//响应状态码为200，代表一切正常  
			if (xmlHttpReq.status == 200) {
				
				// 请求回来的结果:xmlHttpReq.responseText
				// 当服务器数据回来之后的处理
				console.log(xmlHttpReq.responseText);
				var info = document.getElementById("info");
				info.innerHTML= xmlHttpReq.responseText;
			}
		}
	}



</script>
</head>
<body>
<form action="registerchk">
用户名:<input type="text" name="username" id="username"><button type="button" onclick="checkName();">检测</button><span id="info"></span><br />
密码:<input type="password" name="password"><br />
<input type="submit" value="注册">

</form>
</body>
</html>