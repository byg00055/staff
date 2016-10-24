package com.kedu.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kedu.board.dao.BoardDao;
import com.kedu.board.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
)
public class BoardDaoTest {
	
	@Inject
	private BoardDao dao;
	
	private Logger logger=LoggerFactory.getLogger(BoardDaoTest.class);
	
//	@Test
	public void testCreate() throws Exception{
		
		BoardDto board = new BoardDto();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user02");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info(dao.read(5).toString());
	}
	
//	@Test
	public void testUpdate() throws Exception{
		
		BoardDto board = new BoardDto();
		board.setBno(4);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정 테스트");
		dao.update(board);
	}
	
//	@Test
	public void testDelete() throws Exception{
		
		dao.delete(3);
	}

}
