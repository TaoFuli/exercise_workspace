<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>

<script>
	var op = {
		"listCategory" : {
			"title" : "分类列表",
			"url" : "adminCategory"
		},
		"listGoods":{
			"title" : "商品列表",
			"url" : "adminGoods"
		}
	}

	function addTab(type) {
		// tab标题
		var titleStr = op[type].title;
		// 要访问的网址
		var urlStr = op[type].url;

		// 先查找有没有
		var tab = $("#tabs").tabs("getTab", titleStr);

		if (tab == null) 
		{
			$("#tabs").tabs("add",{
						title : titleStr,
						content : '<iframe src="' + urlStr
								+ '" width="100%" height="100%"></iframe>',
						closable : true
					});
		}else
		{
			// 如果已经存在该标题的tab,则更新
			console.log("更新内容");
			$("#tabs").tabs("update",{
				tab:tab,
				options:{
				title : titleStr,
				content : '<iframe src="' + urlStr
						+ '" width="100%" height="100%"></iframe>'
				}
			});
			
		}
		

	}
</script>
</head>
<!-- <body>
${admin.username},欢迎光临<br />
<a href="logout">退出登录</a><br />
<a href="adminCategory">管理分类</a><br />
<a href="adminGoods">管理商品</a><br />

</body>
-->

<body class="easyui-layout">
	<div data-options="region:'north',split:true" style="height: 100px">
		<h1>后台管理</h1>
		<p style="text-align: right">${admin.username},已登录</p>
	</div>
	<div data-options="region:'west',split:true" style="width: 300px">
		<div id="aa" class="easyui-accordion"
			style="width: 300px; height: 200px;">
			<div title="分类管理" data-options="iconCls:'icon-save'"
				style="overflow: auto; padding: 10px;">

				<ul id="tt" class="easyui-tree">
					<li><span><a href="javascript:addTab('listCategory')">分类列表</a></span></li>
				</ul>

			</div>
			<div title="商品管理" data-options="iconCls:'icon-reload',selected:true"
				style="padding: 10px;">
				<ul id="tt" class="easyui-tree">
					<li><span><a href="javascript:addTab('listGoods')">商品列表</a></span></li>
					<li><span>添加商品</span></li>
				</ul>
			</div>
			<div title="会员管理">content3</div>
		</div>
	</div>
	<div data-options="region:'center'">

		<div id="tabs" class="easyui-tabs" data-options="fit:true">
			<div title="管理首页" style="padding: 20px;">管理页面首页</div>
		</div>

	</div>
</body>
</html>