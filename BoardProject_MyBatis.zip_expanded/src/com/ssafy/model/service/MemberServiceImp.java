package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImp;
import com.ssafy.model.dto.Member;

public class MemberServiceImp implements MemberService {
	private MemberDao dao = new MemberDaoImp();

	@Override
	public Member search(String id) {
		return null;
	}

	@Override
	public List<Member> searchAll() {
		return null;
	}

	public boolean login(String id, String pw) {
		return false;
	}

	public boolean checkID(String id) {
		return false;
	}

	public void update(Member member) {
		
	}

	public void remove(String id) {
		
	}

	public void add(Member member) {
		
	}
}
