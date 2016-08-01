package com.kedu.staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kedu.common.db.DBManager;
import com.kedu.staff.dto.EmpDto;

public class StaffDao {

//	전반적인 사원 관련 DB업무를 처리하는 클래스 Dao.
	
//	싱글톤 처리를 위해 기본 생성자를 private로 처리.
	private StaffDao() {
	}
	
//	StaffDao를 사용하게 할 변수 생성.
//	클래스 영역에서 사용하게 하기 위해 static을 붙여준다.
	private static StaffDao instance = new StaffDao();
	
//	만들어진 instance를 사용하기 위한 get메소드 생성
	public static StaffDao getInstance(){
//		instance의 값이 비어있을 경우에는 
		if(instance == null){
//			다시 instance에 StaffDao를 넣어준다.
			instance = new StaffDao();
		}
//		그 후 StaffDao를 담아둔 instance를 반환한다.
		return instance;
	}
	
//	로그인한 사용자의 정보가 있는지 검토하기 위해서 사용하는 메소드
	public int userCheck(String empid, String pass){
//		결과값을 출력하기 위한 변수 result
//		아이디가 없을 경우 0, 비밀번호가 틀릴 경우 -1, 모두 일치할 경우 1.
//		따라서 result의 초기값은 둘다 없다는 가정하의 0으로 한다.
		int result=0;
		
//		쿼리문을 입력하기 위한 문자열 sql
//		아이디를 찾고, 입력한 아이디와 일치하는 아이디의 pass값을 얻어오는 쿼리문을 가져온다.
//		아이디를 찾지 못했을 경우엔 당연히 값이 없다.
		StringBuilder sql = new StringBuilder();
//		가독성을 위해 1줄에는 1개의 문구만 삽입한다.
		sql.append("select		");
		sql.append("pass		");
		sql.append("from		");
		sql.append("emp			");
		sql.append("where		");
		sql.append("empid = ?	");
		
//		커넥션을 받아오기 위한 참조변수 conn
		Connection conn=null;
//		쿼리문을 처리하기 위한 PreparedStatement pstmt
		PreparedStatement pstmt=null;
//		ResultSet은 결과를 얻어오기 위해 사용한다.
		ResultSet rs = null;

//		예외가 발생할 수 있으므로 이하의 작업은 try에서 처리한다.
		try{
//			DBManager의 메소드 getConnection()에는 커넥션의 값이 저장되어 있으므로
//			이 메소드를 이용해 conn에 커넥션 값을 주입한다.
			conn = DBManager.getConnection();
			
//			입력된 커넥션에 쿼리문을 적용한다.
//			StringBuilder를 사용했기 때문에 toString()메소드를 이용해
//			해당 변수를 String형으로 변환해줘야 한다.
			pstmt = conn.prepareStatement(sql.toString());
//			쿼리문의 empid=?에 ?에는 찾아야할 empid 값을 넣어야 한다.
//			그러므로 메소드의 매개변수 empid를 ?위치에 넣어둔다.
			pstmt.setString(1, empid);
//			쿼리문을 실행하고 그 값을 rs에 넣어둔다.
			rs = pstmt.executeQuery();
//			rs에 값이 있는지 판단. 값이 없다는 것은 검색된 id가 없다는 뜻이다.
			if(rs.next()){
				
//				and 연산자 특징상 앞의 식이 false일 경우 뒤의 연산을 행하지 않음.
//				따라서 passward가 없을 경우.(즉, null값일 경우)
//				비교를 하지 않고 넘어간다.
//				암호를 찾아냈을 경우에는 입력한 암호가 올바른지 비교한다.
//				기본적으로 javascript를 이용해 먼저 검토를 하기 때문에 보험용 조건식이다.
				if(rs.getString("pass")!=null 
						&& rs.getString("pass").equals(pass)){
//					암호가 서로 일치할 경우는 아이디, 암호 모두 일치했다는 뜻으로 result에 1을 대입한다.
					result=1;
				}else{
//					암호가 서로 일치하지 않거나, 암호값이 비어있을 경우엔 아이디는 일치하나, 
//					입력한 암호가 없다는 뜻으로 result에 -1을 대입한다. 
					result=-1;
				}
			}else{
//				rs에 값이 없을 경우, 일치하는 id가 없다는 뜻이므로
//				아이디가 없다는 뜻인 0을 result에 대입한다.
				result = 0;
			}
		}catch(SQLException e){
//			SQL예외 상황이 발생했을 경우 어떤 예외인지 출력하게 한다.
			e.printStackTrace();
		}finally {
//			DB사용후에는 반드시 닫아줘야 하므로 DBManager의 close메소드를 이용해
//			사용한 rs, pstmt, conn을 닫아준다.
			DBManager.close(conn, pstmt, rs);
		}
		
//		얻어낸 result값을 반환해서 로그인 성공 여부를 알려준다.
		return result;
	}
	
	
//	로그인한 사용자의 정보를 말아주는 메소드
	public EmpDto EmpLogin(String empid){
//		사용자의 정보를 담을 Dto생성
		EmpDto empDto = null;
		
//		실행할 쿼리문을 작성한다.
//		추후 관리를 위해 쿼리문은 한 줄씩 작성하며
//		작업 공간 효율성을 위해 StringBuilder를 사용한다.
		StringBuilder sql = new StringBuilder();
		sql.append("select		");
		sql.append("empid		");
		sql.append(", empnm		");
		sql.append(", admin		");
		sql.append("from		");
		sql.append("emp			");
		sql.append("where		");
		sql.append("1=1			");
		sql.append("and			");
		sql.append("empid=?		");
		
//		DB연결을 위한 변수들.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
//			DB연결
			conn = DBManager.getConnection();
//			쿼리문 입력
			pstmt = conn.prepareStatement(sql.toString());
//			?값 입력
			pstmt.setString(1, empid);
			
//			쿼리문 실행후 그 값을 rs에 저장
			rs = pstmt.executeQuery();
			
//			rs에 값이 있을 경우(검색에 성공했을 경우)
			if(rs.next()){
				empDto = new EmpDto();
				
//				Dto에는 페이지간에 사용할 사원번호와, 이름, 관리자 여부를 저장한다.
				empDto.setEmpid(rs.getString("empid"));
				empDto.setEmpnm(rs.getString("empnm"));
				empDto.setAdmin(rs.getInt("admin"));
				
			}
			
		}catch(SQLException e){
//			예외상황 발생시 문제점을 표기하게 한다.
			e.printStackTrace();
		}finally {
//			DB 사용후에는 사용한 DB를 닫는다.
			DBManager.close(conn, pstmt, rs);
		}
		
		return empDto;
	}
	

}
