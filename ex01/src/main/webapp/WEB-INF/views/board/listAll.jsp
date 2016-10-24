<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<style type="text/css">
	.thBno{
		width: 10px;
	}
	
	.thViewcnt{
		width:40px;
	}
</style>	
<script type="text/javascript">
	var result = '${msg}';
	
	if(result == 'SUCCESS'){
		alert("처리가 완료되었습니다.");
	}

</script>>
	
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">게시글 리스트</h3>
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<tr>
								<th class="thBno">BNO</th>
								<th>글제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th class="thViewcnt">조회수</th>
							</tr>
							
							<c:forEach items="${list }" var="boardDto">
								<tr>
									<td>${boardDto.bno }</td>
									<td><a href="/board/read?bno=${boardDto.bno}">${boardDto.title }</a></td>
									<td>${boardDto.writer }</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardDto.regdate }"/></td>
									<td><span class="badge bg-red">${boardDto.viewcnt }</span></td>
								</tr>
							</c:forEach>
							
						</table>
					</div>
				</div>
			</div>
		</div>
	
	</section>
	
<%@ include file="../include/footer.jsp"%>