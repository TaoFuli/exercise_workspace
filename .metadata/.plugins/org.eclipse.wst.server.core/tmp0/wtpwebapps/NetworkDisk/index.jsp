<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>主页</title>
	<!-- 1. 引入bootstrap 样式文件 -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	<!-- 2. 导入jQuery -->
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<!-- 添加用于验证的脚本文件 -->
		<script src="js/jquery.validate.min.js"></script>
	<!-- 3. 导入popper 用于弹窗 提示、下拉框 -->
		<script type="text/javascript" src="js/popper.min.js"></script>
	<!-- 4. 导入bootsrap js文件-->
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- 添加一些基础样式文件 -->
		<link rel="stylesheet" type="text/css" href="css/base.css" />
	<!-- 添加支持easyui的样式文件 -->
		<link rel="stylesheet" type="text/css"
				href="easyui/themes/default/easyui.css">
	<!-- 添加easyui的图标样式文件 -->
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<!-- 添加用来支持easyui的jquery脚本 -->
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<!-- 添加easyui的语言支持脚本 -->
		<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

<!-- 关于页面布局的样式 -->
<style type="text/css">
		* {
			color: #000000;
			}
		body {
			background-color: #F6F8FA;
			}
		#bady-big {
			width: 100%;
			height: 100%;
			}
		.body-title {
			float: left;
			width: 181px;
			height: 100%;
			border-right: 1px solid #f0f0f0;
			background-color: white;
			}
		
		#c1 {
			text-align: center;
			height: 80px;
			}
		
		.text {
			color: black;
			}
		
		.text-title {
			font-size: 18px;
			padding: 0px 10px 10px 20px;
					}
		
		.group-pad {
			height: 510px;
					}
		
		.group-foot {
			height: 181px;
			border-top: 1px solid #f0f0f0;
					}
			#updata {
				width: 80%;
				border-top: 3px solid #f0f0f0;
				padding: 10px;
				margin: 0 auto;
					}
		.group-pad a {
			color: #6D6D6D;
					}
		#clr-title {
			float: left;
			width: 87%;
			height: 50px;
			border-bottom: 1px solid #f0f0f0;
			background-color: white;
					}
		.form-inline {
			position: relative;
			top: 6px;
					}
		
		#down-login {
			float: right;
			position: relative;
			top: -28px;
			right: -30px;
					}
		#color123 {
			height: 150px;
			background-color: white;
			border: 1px solid #95B8E7;
					}
		
		.all-file {
			padding: 10px 0 0 20px;
			border-bottom: 3px solid #f0f0f0;;
					}
		
			.mian {
				padding: 70px 0 0 200px;
					}
			.main2 {
				width: 100%;
					}
</style>

</head>
<body>
	<div class="container">
		<div class="body-title clearfix">
			<div id="c1">
				<img src="img/极客.png" style="width: 40px;" /> <span
					style="font-weight: bolder; color: #6F6C6C; letter-spacing: 5px;">极客云</span>
			</div>
			<div class="group-pad">
				<div class="text-title">
					<img src="easyui/demo/tabs/images/modem.png"> <span><a
						href="#"> 我的文件</a> </span>
				</div>
				<div class="text-title">
					<img src="easyui/demo-mobile/images/scanner.png" /> <span
						class="text"><a href="#">我的图片</a> </span>
				</div>
				<div class="text-title">
					<img src="easyui/demo-mobile/images/tablet.png"> <span
						class="text"><a href="#">我的文档</a></span>
				</div>
			</div>
			<div class="group-foot">
				<div style="text-align: center;">
					<button type="button" class="btn btn-default btn-sm"
						style="background-color: #f0f0f0; border-radius: 20px; margin-top: 15px;">
						<span class="glyphicon glyphicon-user" style="font-size: 12px;">免费版</span>
					</button>
				</div>

				<div class="text" id="updata" style="margin-top: 20px;"></div>

				<div class="text" id="updata" style="margin-top: 30px;"></div>

			</div>

		</div>

	<!-- 头部条导航 -->
		<div id="clr-title" class="clearfix">
			<!-- 搜索组件 -->
			<div>
				<form class="form-inline" style="margin-left: 50px;">
					<img src="easyui/themes/black/images/searchbox_button.png" /> <input
						type="text" class="form-control" placeholder="搜索我的文件..."
						style="border: none;" />
					<button class="btn btn-group">搜索</button>
				</form>
			</div>
			<!-- 格式搜索标题 -->
			<div class="container">
				<!-- 搜索标题 -->
						<div class="dropdown" id="down-login">
							<!-- 下拉按钮 -->
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown">晚饭吃什么?</button>
							<!-- 菜单内容 -->
							<div class="dropdown-menu">
								<a href="#" class="dropdown-item">${CurrUser.username }，欢迎您</a> <a
									href="#" class="dropdown-item">登录</a> <a href="loginout.do"
									class="dropdown-item">退出</a>
							</div>
						</div>
				<!-- 搜索标题 结束-->
			</div>
		</div>
	<!-- 头部条导航结束 -->

		<div class="mian">
			<div id="color123">
				<div class="all-file">
					<p style="font-size: 24px;">
						<span class="glyphicon glyphicon-file"></span>查看文件
					</p>
				</div>
			</div>

		<!-- 请求文件列表的div -->
			<div class="main2">
				<table id="dg"></table>
				<!-- ajax异步请求的url的json数据-->
				<script type="text/javascript">
					$(function() {
						//创建数据表格
						$('#dg').datagrid({
									title : '该用户所有文件',
									width : 910,
									height : 550,
									rownumbers : true,
									remoteSort : false,
									nowrap : false,
									fitColumns : true,
									singleSelect : true,
									pagination : true,
									url : 'search.do',
									method : 'get',
									columns : [[ {
										field : 'id',
										title : '编号',
										width : 10,
										sortable : true
									}, {
										field : 'username',
										title : '文件名',
										width : 30,
										align : 'center',
										sortable : true
									}, {
										field : 'loginName',
										title : '文件类型',
										width : 30,
										align : 'center',
										sortable : true
									}, {
										field : 'sex',
										title : '创建时间',
										width : 30,
										align : 'center',
										sortable : true
									},{
										field:'fileSize',
										title:'文件大小',
										width : 30,
										align : 'center',
										sortable : true
									}
									]],
									groupField : 'id',
									groupFormatter : function(value, rows) {
										return value + ' - ' + rows.length
												+ ' Item(s)';
									}
								});
						//分页
						var pager = $('#dg').datagrid().datagrid('getPager'); // 添加分页
						pager.pagination();

					});
				</script>
			</div>
		<!-- 请求文件列表div结束main2 -->
		
		</div>
	</div>

</body>
</html>