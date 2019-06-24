<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 导入头部页面内容 -->
<%@ include file="header.jsp"%>

<div class="container">
	<c:if test="${not empty paging }">

	<%@ include file="pageNum.jsp" %>	
	
		<div class="row">
			<!-- 评论面板 -->
			<div class="col-md-12">
				<c:forEach var="msg" items="${paging.data}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="panel-title">
							<h4>编号：${msg.wid} 用户 ：${msg.fk_uloginName}</h4>
								<div class="text-right">
									<c:if test="${CurrUser.uloginName==msg.fk_uloginName}">
										<a href="delete?wid=${msg.wid}">删除</a>
										<a href="edit?wid=${msg.wid}">修改</a>
									</c:if>
									发布日期：${msg.date }
								</div>
							</div>
						</div>
						<div class="panel-body">
							${msg.wleaveWord }
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 面板结束 -->
		</div>
<%@ include file="pageNum.jsp" %>
	
	</c:if>
</div>
<!-- 导入尾部描述声明 -->
<%@ include file="footer.jsp"%>