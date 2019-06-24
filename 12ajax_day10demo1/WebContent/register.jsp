<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<script type="text/javascript">
	var xmlhttp=null; //定义XMLHttpReques对象
	
	/* 使用ajax异步请求，验证用户名是否可用 */
	function doAjax(val)
	{
		//实例化，需要判断浏览器是不是IE
		if(window.XMLHttpRequest)
			{
				xmlhttp=new XMLHttpRequest();//非IE
			}
		else
			{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
		//设置回调函数 接收返回值
		xmlhttp.onreadystatechange=doSomething;//每次改变一次状态
		
		 /*
	    存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
		0: 请求未初始化 
		1: 服务器连接已建立 
		2: 请求已接收 
		3: 正在响应中
		4: 响应已完成，且响应已就绪 
	 */
	 
	 //设置   open(提交方式,URL,同步和异步)   连接
	 xmlhttp.open("GET","check.do?name="+val ,true);  
	 
	 
	 //发送请求
	 xmlhttp.send(null);
 }
 
 /* 回调函数   接收返回值 */
 function  doSomething(){
	  //alert(xmlhttp.readyState);
	  if(xmlhttp.readyState == 4){
		  if(xmlhttp.status == 200) {  //http状态 200=ok
			   //接收数据
			  //xmlhttp.responseXML 接收返回的XML数据  现在已经不使用了
			  //xmlhttp.responseText;  接受返回的文本数据
			  
			  //接受响应的 text
			  var rs = xmlhttp.responseText;
			  
			  //alert(rs);
			  
			 var  um =  document.getElementById("username_msg");
			  //判断
			  if(rs == 'true'){
				  um.innerText  = "该用户名已经存在了，请换一个！";
				  um.style.color = "red";
			  }else{
				  um.innerText  = "该用户名可以使用";
				  um.style.color = "green";
			  } 
			   
		  }else{
			  alert("请求错误:"+xmlhttp.status);
		  }
	  }
	  
 }

 
</script>
</head>
<body>
<form action="" autocomplete="off">//设置关闭自动完成验证
	<fieldset>
		<legend>用户注册</legend>
		用户：<input type="text" name="username" onblur="doAjax(this.value)"/>
		<span id="username_msg"></span><br>
		密码：<input type="password" name="password">
		<span id="password_msg"></span><br>
		密码确认：<input type="password" name="qpassword">
		<span id="qpassword_msg"></span>
		性别：<input type="radio" name="sex" value="男" checked="checked">男
		<input type="radio" name="sex" value="女">女<br>
		爱好：<input type="checkbox" name="hobby" value="吃饭">吃饭
		<input type="checkbox" name="hobby" value="睡觉">睡觉
		<input type="checkbox" name="hobby" value="打豆豆">打豆豆<br>
		<button>注册</button>
	</fieldset>

</form>

</body>
</html>