package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public class BoardDaoImpl implements BoardDao {
	public void insertBoard(SqlSession session, Board board){
	}
	public void updateBoard(SqlSession session, Board board){
		
	}
	public void deleteBoard(String no) {
		
	}
	public Board search(String no){
		return null;
	}
	public List<Board> searchAll(PageBean bean){
		return null;
	}
	public int getBoardNo(SqlSession session) {
		return 0;
	}
	public int  count(PageBean bean){
		return 0;
	} 
}
