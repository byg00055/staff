package com.kedu.staff.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.common.action.Action;

public class StaffLoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		암호확인창을 url에 입력한다.
		String url = "/login/login.jsp";
		
//		로그인/비로그인 여부 확인을 위해 세션을 받아온다.
		HttpSession session = request.getSession();
		
//		만약 로그인이 되어 있을 경우에는 로그인 창이 아닌, 메인으로 보내버린다.
		if(session.getAttribute("loginEmp") != null){
			url = "/main/main.jsp";
		}
		
//		입력한 url로 편지봉투를 보낸다.
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
		
	}

}
