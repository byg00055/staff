package com.kedu.board.service;

import java.util.List;

import com.kedu.board.dto.BoardDto;

public interface BoardService {
	
	public void regist(BoardDto board)throws Exception;
	
	public BoardDto read(Integer bno) throws Exception;
	
	public void modify(BoardDto board)throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<BoardDto> listAll() throws Exception;
}
