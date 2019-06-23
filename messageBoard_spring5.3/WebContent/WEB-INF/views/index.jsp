<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<div class="container">

<c:if test="${not empty paging}">

<div class="row">
				<div class="col-md-12">
<c:forEach var="msg" items="${paging.data}">
	
	<!-- panel begin -->
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">编号:${msg.id} 用户:${msg.author.username} 发布时间:${msg.publishTime } 
	    	
	    		<c:if test="${CurrUser.id == msg.author.id  }">
					<a href="del?id=${msg.id}">删除</a>
					|
					<a href="edit?id=${msg.id}">修改</a>
				</c:if>
	    </h3>
	  
	  </div>
	  <div class="panel-body">
	    ${msg.context}
	  </div>
	</div>
	<!-- panel end -->
	
	<%-- 
	<table width="80%" border="1">
		<tr>
			<td> 
				编号:${msg.id} 用户:${msg.author.username} 发布时间:${msg.publishTime } 
				&nbsp;&nbsp;&nbsp;&nbsp;
				
				<c:if test="${CurrUser.id == msg.author.id  }">
					<a href="del?id=${msg.id}">删除</a>
					|
					<a href="edit?id=${msg.id}">修改</a>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>${msg.context}</td>
		</tr>
	</table> --%>
	
	
</c:forEach>

</div>
</div>


<%-- 分页信息 --%>
<%-- 当前页/总页数: ${paging.currPage}/${paging.pageCount} 总记录数:${paging.rowsCount} --%>
<%-- <c:forEach var="i" begin="1" end="${paging.pageCount }">
	 &nbsp;<a href="index?p=${i}" >${i}</a> &nbsp;
</c:forEach> --%>


	<div class="row">
				<div class="col-md-12">
					<nav aria-label="Page navigation">
					  <ul class="pagination">
					    <li>
					      <a href="index?p=${paging.currPage-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    
					    <c:forEach var="i" begin="1" end="${paging.pageCount }">
					    <li><a href="index?p=${i}">${i}</a></li>
					    </c:forEach>
					    <li>
					      <a href="index?p=${paging.currPage+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>	
				</div>			
			</div>


</c:if>

</div>

<%@ include file="footer.jsp"%>