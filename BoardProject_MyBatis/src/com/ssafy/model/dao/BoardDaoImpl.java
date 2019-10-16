package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public class BoardDaoImpl implements BoardDao {
	SqlSession session = MyBatis.getSqlSession();
	
	//transaction 대상이라서 service단에서 commit 수행
	public void insertBoard(SqlSession session, Board board){
		session.insert("board.insert", board);
	}
	public void updateBoard(SqlSession session, Board board){
		session.update("board.update", board);
	}
	public void deleteBoard(String no) {
		session.delete("board.delete", no);
		session.commit();
		//delete cascade 옵션이 실행된 경우 이므로 transaction을 안함
	}
	public Board search(String no){
		return session.selectOne("board.search", no);
	}
	public List<Board> searchAll(PageBean bean){
		RowBounds rows = new RowBounds(bean.getStart()-1, bean.getInterval());
		return session.selectList("board.searchAll", bean, rows);
	}
	public int getBoardNo(SqlSession session) {
		return session.selectOne("board.boardNo");
	}
	public int  count(PageBean bean){
		return session.selectOne("board.count", bean);
	} 
}
