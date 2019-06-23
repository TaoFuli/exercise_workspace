<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页查询</title>
</head>
<body>
<form action="search.do" method="get">
		<input type="hidden"  name="ttt"  value="yes" >
		<input name="queryString"  value="${queryString }"    placeholder="请输入用户名模糊查询" />
		<button>查询</button>
</form>
<hr>

<c:if  test="${not empty paging }">
<table style="align:center;width:80%;">
	
	<thead>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>登录名</td>
			<td>性别</td>
			<td>生日</td>
			<td>邮箱</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="user" items="${paging.data}">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.loginName }</td>
					<td>${user.sex }</td>
					<td>${user.birthday }</td>
					<td>${user.email }</td>
				</tr>
		</c:forEach>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="6">
				当前页/总页数:${paging.currPage }/${paging.pageCount }
				&nbsp;&nbsp;
				总记录数:${paging.rowsCount }
				&nbsp;&nbsp;&nbsp;&nbsp;
				
				<c:if test="${paging.currPage>1}">
					<a href="search.do?p=${paging.currPage-1 }">上一页</a>
				</c:if>
				<a href="search.do?p=1">第一页</a>
				
				<c:forEach var="i"  begin="1" end="${paging.pageCount }">
						<c:if test="${i == paging.currPage }">
								${i }
						</c:if>
						
						<c:if test="${i != paging.currPage }">
							<a href="search.do?p=${i }">${i }</a>
						</c:if>
				</c:forEach>
				
				<c:if test="${paging.currPage < paging.pageCount}">
				<a href="search.do?p=${paging.currPage+1 }">下一页</a>
				</c:if>
				
				<a href="search.do?p=${paging.pageCount }">最后页</a>
			</td>
		</tr>
	</tfoot>
	
</table>
</c:if>



</body>
</html>