package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public class MemberDaoImp implements MemberDao {
	private SqlSession session = MyBatis.getSqlSession();
	public void insertMember(Member member){
		/*insert(String id, Object parameter)
		 * id에 해당하는 쿼리를 executeUpdate()로 수행 시켜주는 함수
		 * id : xml로 작성한 쿼리 id
		 *  namespace.id 
		 * parameter : ?에 설정할 데이터*/
		session.insert("member.insert", member);
		session.commit();
	}
	public void deleteMember(String id) {
		session.delete("member.delete", id);
		session.commit();
	}
	public void updateMember(Member member){
		session.update("member.update", member);
		session.commit();
	}
	public Member search(String id) {
		/* selectOne(String id, Object param)
		 * - 한개의 데이터만 추출할 때 사용하는 함수
		 * - 두개 이상의 데이터가 추출되면 error 발생*/
		return session.selectOne("member.search", id);
	}
	public List<Member> searchAll(PageBean bean) {
		/* RowBounds(offset, limit)
		 * offset : 데이터를 추출할 시작 번호 , 0부터 시장
		 * limit : 데이터를 추출할 개수
		 * */
		RowBounds rows = new RowBounds(bean.getStart()-1, bean.getInterval());
		return session.selectList("member.searchAll", bean, rows);
	}
	public int count(PageBean bean){
		return session.selectOne("member.count", bean);
	}
}





