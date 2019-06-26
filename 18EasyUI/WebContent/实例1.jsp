<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		// 1. 让左侧的学科div可以拖动
		$('.left .item').draggable({
			revert:true,
			proxy:'clone'
		});
		
		// 2. 让右侧的td能够接收
		$('.right td.drop').droppable({
			onDragEnter:function(){
				$(this).addClass('over');
			},
			onDragLeave:function(){
				$(this).removeClass('over');
			},
			onDrop:function(e,source){
				$(this).removeClass('over');
				
				if ($(source).hasClass('assigned'))
				{
					// 挪动
					$(this).append(source);
				} else 
				{
					// 复制一份学科
					var c = $(source).clone().addClass('assigned');
					// 当前td清空，放入复制出来的学科
					$(this).empty().append(c);
					// 这块也要能够拖动
					c.draggable({
						revert:true
					});
				}
			}
		});
	});
</script>
<style type="text/css">
	.left{
		float:left;
		width:120px;
	}
	.left table{
		background-color:#e0ecff;
	}
	.left td{
		background-color:#eee;
	}
	.item{
		text-align:center;
		border:1px solid #499b33;
		width:100px;
		background-color:#fafafa;
	}
	.right{
		float:left;
		width:600px;
	}
	.right table{
		background-color:#e0ecff;
		width:100%;
	}
	.right td{
		background-color:#e0ecff;
		text-align:center;
		padding:2px;
	}
	.right td.drop{
		background-color:#fafafa;
		width:100px;
	}
	.right td.over{
		background-color:#f8ec88;
	}
	
</style>
</head>
<body>

	<div>
		<div class="left">
			<table>
				<tr>
					<td><div class="item">语文</div></td>
				</tr>
				<tr>
					<td><div class="item">数学</div></td>
				</tr>
				<tr>
					<td><div class="item">外语</div></td>
				</tr>
				<tr>
					<td><div class="item">体育</div></td>
				</tr>
				<tr>
					<td><div class="item">物理</div></td>
				</tr>
				<tr>
					<td><div class="item">化学</div></td>
				</tr>
			</table>
		</div>
		<div class="right">
			<table>
				<tr>
					<td></td>
					<td class="title">星期一</td>
					<td class="title">星期二</td>
					<td class="title">星期三</td>
					<td class="title">星期四</td>
					<td class="title">星期五</td>
				</tr>
				<tr>
					<td class="time">08:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">09:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">10:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">11:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">12:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">13:00</td>
					<td colspan="5">午休</td>
				</tr>
				<tr>
					<td class="time">14:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">15:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
				<tr>
					<td class="time">16:00</td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
					<td class="drop"></td>
				</tr>
			</table>

		</div>
	</div>

</body>
</html>