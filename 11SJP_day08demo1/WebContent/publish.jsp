<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>

<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="context"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
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


<div>
	<form action="publish" method="post">
		<fieldset>
			<legend>发布留言</legend>
			<h1 style="color:Red;">${Err}</h1>
			当前用户: ${CurrUser.username}
			<br />
			<textarea rows="5" cols="20" name="context" placeholder="请输入留言的内容"></textarea>
			
			<br />
			<button>发布留言</button>
		</fieldset>
	</form>
</div>

<%@ include file="footer.jsp"%>