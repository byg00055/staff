package com.kedu.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
//	다른 액션들을 실행하기 위한 인터페이스
//	액션 인터페이스가 있기 때문에 다른 클래스를 유동적으로 사용할 수 있다.
	public void execute(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException;
}
