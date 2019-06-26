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
<script>
	var data = {
		"total" : 0,
		"rows" : []
	};
	var totalCost = 0;

	$(function() {

		// 1. 让商品可拖动
		$('.item').draggable({
			revert : true,
			proxy : 'clone',
			onStartDrag : function() {
				$(this).draggable('options').cursor = 'not-allowed';
				$(this).draggable('proxy').css('z-index', 10);
			},
			onStopDrag : function() {
				$(this).draggable('options').cursor = 'move';
			}
		});

		// 2. 让购物车右侧一块可以处理拖动内容
		$('#cartcontent').datagrid({
			singleSelect : true
		});

		$('.cart').droppable({
			onDragEnter : function(e, source) {
				$(source).draggable('options').cursor = 'auto';
			},
			onDragLeave : function(e, source) {
				$(source).draggable('options').cursor = 'not-allowed';
			},
			onDrop : function(e, source) {
				var name = $(source).find('p:eq(0)').html();
				var price = $(source).find('p:eq(1)').html();
				price = price.split(':')[1];
				price = price.substr(0,price.length-1);
				addProduct(name, parseFloat(price));
			}
		});

	});

	function addProduct(name, price) {
		function add() {
			for (var i = 0; i < data.total; i++) {
				var row = data.rows[i];
				if (row.name == name) {
					row.quantity += 1;
					return;
				}
			}
			data.total += 1;
			data.rows.push({
				name : name,
				quantity : 1,
				price : price
			});
		}
		add();
		totalCost += price;
		console.log(data);
		$('#cartcontent').datagrid('loadData', data);
		$('div.cart .total').html('总价: ' + totalCost+"元");
	}
</script>
<style>
.products {
	list-style: none;
	margin-right: 300px;
	padding: 0px;
	height: 100%;
}

.products li {
	display: inline;
	float: left;
	margin: 10px;
}

.item {
	display: block;
	text-decoration: none;
}

.item img {
	border: 1px solid #333;
}

.item p {
	margin: 0;
	font-weight: bold;
	text-align: center;
	color: #c3c3c3;
}

.cart {
	position: fixed;
	right: 0;
	top: 0;
	width: 300px;
	height: 100%;
	background: #ccc;
	padding: 0px 10px;
}

h1 {
	text-align: center;
	color: #555;
}

h2 {
	position: absolute;
	font-size: 16px;
	left: 10px;
	bottom: 20px;
	color: #555;
}

.total {
	margin: 0;
	text-align: right;
	padding-right: 20px;
}
</style>
</head>
<body>
	<ul class="products">
		<li><a href="#" class="item"><img src="images/shirt1.gif" />
			<div>
					<p>气球T恤</p>
					<p>价格:25元</p>
				</div></a></li>
		<li><a href="#" class="item"><img src="images/shirt2.gif" />
			<div>
					<p>感觉T恤</p>
					<p>价格:15元</p>
				</div></a></li>
		<li><a href="#" class="item"><img src="images/shirt3.gif" />
			<div>
					<p>大象T恤</p>
					<p>价格:35元</p>
				</div></a></li>
		<li><a href="#" class="item"><img src="images/shirt4.gif" />
			<div>
					<p>StampsT恤</p>
					<p>价格:100元</p>
				</div></a></li>
		<li><a href="#" class="item"><img src="images/shirt5.gif" />
			<div>
					<p>MongoT恤</p>
					<p>价格:101元</p>
				</div></a></li>
		<li><a href="#" class="item"><img src="images/shirt6.gif" />
			<div>
					<p>XXXXT</p>
					<p>价格:125元</p>
				</div></a></li>
	</ul>
	<div class="cart">
		<h1>购物车</h1>
		<div style="background-color: #fff">
			<table id="cartcontent" fitColumns="true" style="width: 300px; height: auto">
				<thead>
					<tr>
						<th field="name" width=140>商品名</th>
						<th field="quantity" width=60>数量</th>
						<th field="price" width=60>价格</th>
					</tr>
				</thead>
			</table>
		</div>
		<p class="total">总价:0元</p>
		<h2>将商品拖到右侧购物车</h2>
	</div>

</body>
</html>