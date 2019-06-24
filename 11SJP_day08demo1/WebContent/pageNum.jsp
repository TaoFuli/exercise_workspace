<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 分页内容 -->
		<div class="row">
			<div class="col-md-12">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<li>
							<a href="<c:if test="${paging.currPage>1}">
											search?p=${paging.currPage-1}
									</c:if>"
							aria-label="Previous" >
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<c:forEach var="i" begin="1" end="${paging.pageCount}">
							<li>
								<a href="search?p=${i}">${i}</a>
							</li>
						</c:forEach>
						<li>
							<a href="<c:if test='${paging.currPage<paging.pageCount}'>
										search?p=${paging.currPage+1}
									</c:if>"
							aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	<!-- 分页结束 -->