package com.kedu.staff.controller;

import com.kedu.common.action.Action;
import com.kedu.staff.controller.action.StaffLoginAction;
import com.kedu.staff.controller.action.StaffLoginFormAction;

public class ActionFactory {
	
	private ActionFactory(){
		
	}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance(){
		
		if(instance == null){
			instance = new ActionFactory();
		}
		return instance;
	}
	
//	입력받은 액션에 따라 다른 액션으로 이동시킬 메소드 getAction
	public Action getAction(String command){
		
//		먼저 인터페이스 action을 선언한다.
//		인터페이스인 Action은 다른 Action을 유동적으로 사용할 수 있다.
		Action action = null;
		
//		중간 점검을 위한 출력문.
//		완성 후에는 삭제해야 한다.
		System.out.println("ActionFactory : "+command);
		
//		staff_loginform 커맨드를 입력받았을 경우
		if(command.equals("staff_loginForm")){
//			로그인 창으로 이동하게 하는 역할을 하는 클래스인 StaffLoginFormAction을 action에 저장한다.
			action = new StaffLoginFormAction();
		}else if(command.equals("staff_login")){
//			staff_login은 실질적인 로그인 처리를 하는 클래스인 StaffLoginAction을 action에 저장한다.
			action = new StaffLoginAction();			
		}else if(command.equals("staff_insert")){
		}else if(command.equals("staff_delete")){
		}
		
		
		
		return action;
	}

}
