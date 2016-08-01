<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>로그인 화면</title>
<c:if test="${!(empty message)}">
	<script type="text/javascript">
	alert('${message }');
	</script>
</c:if>
<!-- 배경을 장식하는 base css파일 양식 가져옴. -->
<link rel="stylesheet" href="./css/base.css">
<!-- 로그인창을 장식하는  login css파일 양식 가져옴. -->
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/jquery-ui.min3.css">
<style type="text/css">

/* 로그인 박스의 위치 조정용 css*/
#logintable{
	position: relative;
	top:100px;
	left:70px;
}
</style>
</head>
<body>
<!-- 비 로그인시의 헤더 파일을 불러와서 장식 시킴. -->
<div id="base_warp">
	<!-- 로그인 창은 비 로그인 상태이므로 비 로그인 헤더를 나타내는 outheader를 불러온다. -->
	<jsp:include page="/include/outheader.jsp"/>
	<div id="login_warp" class="ui-widget ui-widget-content">
	<!-- 아이디/암호 입력창 -->
		<form method="post" action="staff.do?command=staff_login" name="log">
			<table id="logintable">
			<tr>
				<!-- 아이디 입력 -->
				<td><label for="empid">아이디 : </label></td>
				<td><input type="text" id="empid" name="empid" placeholder="아이디를 입력하세요."/></td>
			</tr>
			<tr>
				<!-- 암호 입력 -->
				<td><label for="pass">암 &nbsp;호 : </label></td>
				<td><input type="password" id="pass" name="pass" placeholder="비밀번호를 입력하세요."/></td>
			</tr>
			<tr>
				<!-- 입력 받은 정보를 LoginServlet으로 넘기는 submit 버튼. -->
				<td><input type="submit" class="ui-button" value="입력"/></td>
			</tr>
			</table>
		</form>
	</div>
</div>

</body>
</html>