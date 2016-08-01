<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String uid="kedu";
	String pass="1234";
	String sql="select * from member";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인 필터</title>
</head>
<body>
<% 
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String dname="";
	String cpwd="";
	boolean scan=false;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,uid,pass);
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		while(rs.next()){
			if(id.equals(rs.getString("id"))){
				scan=true;
				if(pwd.equals(rs.getString("pwd"))){
					HttpSession ms = request.getSession();
					dname=rs.getString("dname");
					ms.setAttribute("id", id);
					ms.setAttribute("pwd", pwd);
					ms.setAttribute("dname", dname);
					%>
					<jsp:forward page="../main/main.jsp"/>
				<% 
				}else{
				%>
				<script type='text/javascript'>
				alert('비밀번호가 틀렸습니당.');
				history.go(-1);
				</script>
				<%
				}
				break;
			}
		}
		if(!scan){
			%>
			<script type='text/javascript'>
			alert('아이디가 없습니당.');
			history.go(-1);
			</script>
			<%
		}
	}catch(SQLException e){
		
	}finally{
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
		}
	}
	
%>
</body>
</html>