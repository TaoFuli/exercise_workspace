<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div>
	<form action="edit" method="post">
		<fieldset>
			<legend>修改留言</legend>
			<h1 style="color:Red;">${Err}</h1>
			当前用户: ${CurrUser.username}
			<br />
			<input type="text" name="id" value="${EditMessage.id}" readonly="readonly">
			<textarea rows="5" cols="20" name="context" placeholder="请输入留言的内容">${EditMessage.context }</textarea>
			
			<br />
			<button>修改并发布留言</button>
		</fieldset>
	</form>
</div>

<%@ include file="footer.jsp"%>