<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- header이므로 header부분을 꾸미는 header css 파일을 적용한다. -->
<link rel="stylesheet" href="css/header.css">

<style type="text/css">

/* 로그아웃 버튼을 꾸미는 css*/
#subbtn{
	width:80px;
	height:30px;
}
</style>

</head>
<body>
<!-- 로그인 하지 않은 상태에서는 경고와 함께 이전 페이지로 강제로 이동 시킨다. -->
<c:if test="${loginEmp.empid == null}">
		<script type="text/javascript">
		alert('비정상적인 접근입니다.');
		history.go(-1);
		</script>
</c:if>
<!-- header div이므로 헤드를 꾸미는 head_warp를 적용한다. -->
<div id="head_warp">
	<h1>사원 정보 관리 시스템</h1>
	<!-- 로그아웃 버튼을 누를 경우 로그아웃한다. -->
	<form method="post" action="LogoutServlet">
		<p id="rightuser">${loginEmp.empnm}
		<!-- 로그인한 사람이 관리자일 경우, 이름 옆에(관리자)라는 표시가 뜨게 한다. -->
		<c:if test="${loginEmp.admin==1}">
		(관리자)
		</c:if>
		<input type="submit" value="로그아웃" class="ui-button"/>
		</p>
	</form>
</div>
</body>
</html>