<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-footer {
      background-color: #f9f9f9;
  }
  </style>
</head>
<body>


<div class="container">
	<h1>사원 정보 관리시스템</h1>
	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-default btn-lg" id="myBtn">Login</button>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">
	    	<!-- Modal content-->
    		<div class="modal-content">
				<div class="modal-header" style="padding:35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h2><span class="glyphicon glyphicon-lock"></span>사원 로그인</h2>
				</div>
				<div class="modal-body" style="padding:40px 50px;">
				<form method="post" action="../LoginServlet" name="log" role="form">
    	        <div class="form-group">
					<label for="usrname">
					<span class="glyphicon glyphicon-user"></span>ID</label>
					<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요.">
				</div>
				<div class="form-group">
					<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
					<input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요.">
				</div>
				<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
				</form>
				</div>
				<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				</div>
			</div>
		</div>
	</div>
</div>
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>
<%--
<div id="warp">
	<div id="innerwarp">
	<form method="post" action="../main/loginfilter.jsp" name="log">
		<strong>id</strong><br/>
		<input type="text" id="id" name="id"/><br/>
		<strong>password</strong><br/>
		<input type="password" id="pwd" name="pwd"/><br/>
		<input type="submit"/>
	</form>
	</div>
</div>
--%>
</body>
</html>