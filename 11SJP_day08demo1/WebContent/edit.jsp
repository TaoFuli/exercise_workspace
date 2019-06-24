<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<!-- 导入头部和导航栏 -->
<%@ include file="header.jsp"%>

<!-- 添加编辑的脚本插件 -->
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>

<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="context"]', {
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
</script>

<!-- 修改编辑内容 -->
<div>
	<form action="edit" method="post">
		<fieldset>
			<legend>修改留言</legend>
			<h1 style="color:Red;">${Err}</h1>
			当前用户: ${CurrUser.username}
			<br />
			<input type="text" name="id" value="${EditLeaveWord.wid }" readonly="readonly">
			<textarea rows="5" cols="20" name="context" placeholder="请输入留言的内容">
				${EditLeaveWord.wleaveWord}
			</textarea>
			
			<br />
			<button>修改并发布留言</button>
		</fieldset>
	</form>
</div>

<!-- 导入足部内容 -->
<%@ include file="footer.jsp"%>