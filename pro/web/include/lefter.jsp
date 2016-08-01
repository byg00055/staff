<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴</title>
<!-- lefter는 왼쪽 메뉴를 차지하는 부분이므로 left css파일을 이용해 장식한다. -->
<link rel="stylesheet" href="css/left.css">
</head>
<body>
<div id="left_warp">
	<p>개인 프로젝트 이력 관리</p>
	<br>
	<ul>
		<li>프로젝트 이력 목록</li>
		<li>프로젝트 이력 등록</li>
	</ul>
	<p>개인 정보 관리</p>
	<br>
	<ul>
		<li>사원 정보 목록</li>
		<!-- 관리자일 경우, 사원 정보 수정이라는 메뉴가 보이게 함. -->
		<c:if test="${member.admin == 1 }">
		<li id="splist">사원 정보 수정</li>
		</c:if>
	</ul>
	<p>공지사항</p>
</div>


</body>
</html>