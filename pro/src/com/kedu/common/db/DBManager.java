package com.kedu.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
// 	github 처리?
//	커넥션을 얻어오는 메소드
	public static Connection getConnection(){
		Connection conn = null;
		try{
//			커넥션 풀을 전부 불러온다.
			Context initContext = new InitialContext();
//			커넥션 풀에서 환경설정을 적용한 후, 적용된 커넥션 풀을 가져온다.
			Context envContext = (Context) initContext.lookup("java:/comp/env");
//			그렇게 가져온 커넥션 풀에서 원하는 데이터 소스를 가져온다.
			DataSource ds = (DataSource) envContext.lookup("jdbc/staff");
//			뽑아낸 데이터 소스에 있는 커넥션을 뽑아서 해당 커넥션에 적용시킨다.
			conn=ds.getConnection();
		}catch(SQLException e){
//			예외 발생시 메세지 표시
			e.printStackTrace();
		}catch (NamingException e) {
			e.printStackTrace();
		}
//		커넥션을 반환한다. 실패했을 경우엔 null을 반환한다.
		return conn;
	}
	
//	예외 상황이 발생했다고 해도
//	열어둔 Result, PreparedStatement, Connection은 닫아야 한다.
//	DBManager의 close 메소드는 이 닫기 처리를 위한 메소드로,
//	Dao문의 finllay문구에서 실행된다.
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
//			그리고 SQL예외 상황이 발생할 수 있으므로 닫는 작업은 try안에서 처리한다.
//			rs가 pstmt를 사용하고 있고, pstmt는 conn을 사용하고 있기 때문에 순서대로 닫아야함.
//			닫는 순서는 Result -> PreparedStatement -> Connection.
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
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt){
		try{
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}
