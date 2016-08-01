package com.kedu.staff.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.action.Action;

@WebServlet("/staff.do")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StaffServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		커맨드를 입력받았을 경우 그 커맨드를 가져온다.
		String command = request.getParameter("command");
		
		System.out.println("StaffServlet에서 요청을 받음을 확인 : "+command);
		
//		커맨드를 입력하지 않고 들어와서 커맨드에 아무런 값이 존재하지 않을 경우에는
//		로그인 창으로 이동하게 하는 커맨드를 입력한다.
		if(command==null){
			command="staff_loginForm";
		}
		
//		액션 팩토리 클래스는 싱글톤 패턴이므로 getInstance메소드를 이용해 받아온다.
		ActionFactory actionFactory = ActionFactory.getInstance();
		
//		액션 팩토리에 커맨드를 대입시켜서 입력한 커맨드에 맞는 action을 가져온다. 
		Action action=actionFactory.getAction(command);
		
//		정상적으로 액션을 받아왔을 경우, 그 액션을 실행시킨다.
		if(action != null){
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
