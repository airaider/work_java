package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dao.FileDao;
import com.ssafy.model.dao.FileDaoImp;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = new BoardDaoImpl();
	FileDao  fileDao = new FileDaoImp();
	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}

	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertBoard(Board board) {
		
	}

	@Override
	public void updateBoard(Board board) {
		
	}

	@Override
	public void deleteBoard(String no) {
		
	}

	@Override
	public Board search(String no) {
		return null;
	}

	@Override
	public List<Board> searchAll(PageBean bean) {
		return null;
	}
}









