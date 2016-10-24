package com.kedu.board.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl implements BankDao {

	@Override
	public boolean aSelect(int money) throws Exception {
		return false;
	}

	@Override
	public int aUpdate(int money) throws Exception {
		return 0;
	}

	@Override
	public boolean bSelect(int money) throws Exception {
		return false;
	}

	@Override
	public int bUpdate(int money) throws Exception {
		return 0;
	}

}
