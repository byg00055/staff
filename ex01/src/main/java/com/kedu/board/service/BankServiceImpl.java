package com.kedu.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kedu.board.dao.BankDao;

//비즈니스 로직에서는 처리해주는 구문이 있어야 함.
@Service
public class BankServiceImpl implements BankService {
	
	@Inject
	private BankDao bank;
	
	@Override
	public boolean output(int a, int b, int money) throws Exception {
		if(bank.aSelect(money)){
			System.out.println("계좌 있음");
		}else{
			System.out.println("계좌 없음 ㅎㅎ");
			return false;
		}
		bank.aUpdate(money);
		if(bank.bSelect(money)){
			System.out.println("계좌 있음 ㅎㅎ");
		}else{
			System.out.println("계좌없음");
		}
		bank.bUpdate(money);
		
		return false;
	}

}
