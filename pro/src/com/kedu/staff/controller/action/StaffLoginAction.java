package com.kedu.staff.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.common.action.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.EmpDto;

public class StaffLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		url지정
		String url="/login/login.jsp";
		
//		login.jsp에서 입력한 userid와 pwd를 받아온다.
		String empid = request.getParameter("empid");
		String pass = request.getParameter("pass");
		
		System.out.println(empid + " : " + pass);
		
//		StaffDao를 포함시킨다.
//		다만, StaffDao()는 private이기 때문에 StaffDao()를 받아온 instance를 대신 얻어온다.
		StaffDao staffDao = StaffDao.getInstance();

//		아이디와 비밀번호를 올바르게 입력했는지에 대한 결과를 판별한 후 처리 결과에 따른 값을 result에 입력한다.
		int result=staffDao.userCheck(empid, pass);
		
//		result가 1인 경우, 처리가 올바르게 된 것이므로 그에 대한 처리를 한다.
		if(result==1){
//			실질적인 값을 저장하는 EmpDto를 참조한다.
			
			EmpDto empDto = staffDao.EmpLogin(empid);			
			
//			로그인한 값을 세션에 저장시키기 위해 세션을 불러온다.
			HttpSession session = request.getSession();

//			로그인한 값을 세션에 저장한다.
			session.setAttribute("loginEmp", empDto);
//			로그인에 성공했을 경우 성공했다는 문구를 리퀘스트에 저장한다.
			request.setAttribute("message", empDto.getEmpnm()+"님의 방문을 환영합니다!");
//			로그인에 성공했으므로 메인화면으로 이동하기 위해 url의 값을 바꾼다.
			url="/main/main.jsp";
		}else if(result==-1){
//			result의 값이 0인 경우는 입력한 아이디와 일치하는 아이디를 찾았지만, 비밀번호가 틀렸을 경우.
//			비밀번호가 틀렸을 경우에는 비밀번호가 틀렸다는 메세지를 리퀘스트에 저장한다.
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result==0){
//			result의 값이 -1인 경우는 입력한 아이디와 일치하는 아이디가 없다는 뜻.
//			아이디를 찾지 못했을 경우에는 아이디가 없다는 메세지를 리퀘스트에 저장한다.
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
//		로그인에 성공했을 경우에는 main화면으로 이동하는 url을, 
//		실패했을 경우에는 로그인 창으로 다시 돌아가는 url을 편지봉투에 입력한다.
		RequestDispatcher disp =
				request.getRequestDispatcher(url);
//		편지봉투에 써진 주소로 페이지를 이동시킨다.
		disp.forward(request, response);
	}

}
