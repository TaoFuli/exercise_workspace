<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
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
</head>
<body>
	<div class="container">
	
	<table title="Complex TreeGrid" class="easyui-treegrid" 
		style="width:550px;height:250px"	url="data/treegrid2_data.json"
    	rownumbers="true" showFooter="true" idField="id" treeField="region">
    	<thead frozen="true">
    		<tr>
    			<th field="region" width="150">Region</th>
    		</tr>
    	</thead>
    	<thead>
    		<tr>
    			<th colspan="4">2009</th>
    			<th colspan="4">2010</th>
    		</tr>
    		<tr>
    			<th field="f1" width="50" align="right">1st qrt.</th>
    			<th field="f2" width="50" align="right">2st qrt.</th>
    			<th field="f3" width="50" align="right">3st qrt.</th>
    			<th field="f4" width="50" align="right">4st qrt.</th>
    			<th field="f5" width="50" align="right">1st qrt.</th>
    			<th field="f6" width="50" align="right">2st qrt.</th>
    			<th field="f7" width="50" align="right">3st qrt.</th>
    			<th field="f8" width="50" align="right">4st qrt.</th>
    		</tr>
    	</thead>
    </table>
	
	
	
	
		<table id="shared_t"></table>
		<!-- 用ajax请求json数据 -->
		<script type="text/javascript">
			$(function(){
				$("#shared_t").datagrid({
					width:1110,
					height:350,
					rownumber:true,
					remoteSort:false,
					nowrap:false,
					fitColumns:true,
					singleSelect:true,
					pagination:true,
					url:'sharedFile.do',
					method:'get',
					columns:[[{
						field:'sid',
						title:'编号',
						width:10,
						sortable:true
					},{
						field:'fileName',
						title:'文件名',
						width:30,
						align:'center',
						sortable:true
					},{
						field:'filePath',
						title:'文件路径',
						width:30,
						align:'center',
						sortable:true
					},{
						field:'fileType',
						title:'文件类型',
						width:30,
						align:'center',
						sortable:true
					},{
						field:'loginName',
						title:'登录名',
						width:30,
						align:'center',
						sortable:true
					},{
						field:'sharedTime',
						title:'共享截止日期',
						width:30,
						align:'center',
						sortable:true
					},{
						field:'sCreateTime',
						title:'开始分享日期',
						width:30,
						align:'center',
						sortable:true
					}
					]],
					groupField : 'sid',
					groupFormatter : function(value, rows) {
						return value + ' - ' + rows.length
								+ ' Item(s)';
					}
				});
				var pager = $('#shared_t').datagrid().datagrid('getPager'); // 添加分页
				pager.pagination();
				var ids=[];
				var rows=$('#shared_t').datagrid('getSelections');
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].itemid);
				}
				alert(ids.join(''));
			})
		</script>
	
	</div>

</body>
</html>