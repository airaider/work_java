package com.ssafy;

import java.util.List;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImp;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;
public class BoardTest {
	public static void main(String[] args) {
		BoardDao dao = new BoardDaoImp();
		try {
//			PageBean bean = new PageBean("title", "처음", 2);
//			PageBean bean = new PageBean("id", "ncia", 1);
			System.out.println(dao.search("1"));
			
			PageBean bean = new PageBean("contents", "a", 2);
			List<Board> list = dao.searchAll(bean);
			for (Board board : list) {
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
