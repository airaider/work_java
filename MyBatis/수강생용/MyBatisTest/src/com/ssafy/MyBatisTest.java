package com.ssafy;

import java.util.List;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImp;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public class MyBatisTest {

	public static void main(String[] args) {
		Member member = 
		 new Member("test", "1111", "업데이트", "admin@test.com", "서울시");
		
		MemberDao dao = new MemberDaoImp();
//		try {
//			dao.insertMember(member);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			dao.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(dao.search("test"));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			dao.deleteMember("test");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			PageBean bean = new PageBean("all", null, 1);
			List<Member> members = dao.searchAll(bean);
			for (Member mem : members) {
				System.out.println(mem);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			PageBean bean = new PageBean("address", "구", 1);
			System.out.println(dao.count(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
