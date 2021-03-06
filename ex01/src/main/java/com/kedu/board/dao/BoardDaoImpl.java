package com.kedu.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kedu.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	private SqlSession session;

	private static String namespace 
		= "com.kedu.board.mappers.BoardMapper";
	
	@Override
	public void create(BoardDto dto) throws Exception {
		session.insert(namespace+".create", dto);
	}

	@Override
	public BoardDto read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardDto dto) throws Exception {
		session.update(namespace+".update", dto);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

}
