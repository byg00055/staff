<%-- 로그인 후 입장하는 메인메뉴.
	관리자와 일반 회원을 분류해야 한다.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
<script type="text/javascript" src="jquery-1.10.2.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/foot.css">
<link rel="stylesheet" href="css/left.css">
<link rel="stylesheet" href="css/center.css">
<style type="text/css">

#rightuser{
	font-size: 10px;
}

#warp_main{
	width:1000px;
	height:700px;
	background-color:#151;
	float:right;
}

</style>
</head>
<body>
<div id="base_warp">
	<jsp:include page="../include/header.jsp"/>
	<div id="center_warp">
		<jsp:include page="../include/lefter.jsp"/>
		<div id="warp_main">
				id : ${loginEmp.empid }<br/>
				관리여부 : 
				<c:if test="${loginEmp.admin==1}">
				관리자
				</c:if>
				<c:if test="${loginEmp.admin==0 }">
				사원
				</c:if>
				<br/>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp"/>
</div>
		
</body>
</html>