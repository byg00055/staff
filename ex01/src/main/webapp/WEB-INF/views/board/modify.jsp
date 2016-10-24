<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
	
	<script type="text/javascript">
		
	
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click",function(){
			self.location = "/board/listAll";
		});
		
		$(".btn-primary").on("click",function(){
			formObj.submit();
		});
		
	});
		
	</script>
	
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box">
				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">글 번호</label>
							<input type="text" name="bno" class="form-control" value="${boardDto.bno }" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label>
							<input type="text" name="title" class="form-control" value="${boardDto.title }">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="content" rows="3">${boardDto.content}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">작성자</label>
							<input type="text" name="writer" class="form-control" value="${boardDto.writer }" readonly="readonly"/>
						</div>
					</div>
				</form>
						
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">SAVE</button>
						<button type="submit" class="btn btn-warning">CANCEL</button>
					</div>
				</div>
			</div>
		</div>
	
	</section>
	
<%@ include file="../include/footer.jsp"%>