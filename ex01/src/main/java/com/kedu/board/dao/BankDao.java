package com.kedu.board.dao;

public interface BankDao {
	public boolean aSelect(int money) throws Exception;
	
	public int aUpdate(int money) throws Exception;
	
	public boolean bSelect(int money) throws Exception;
	
	public int bUpdate(int money) throws Exception;
	

}
