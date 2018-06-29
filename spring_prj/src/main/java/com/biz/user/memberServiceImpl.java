package com.biz.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service // 서비스 객체
public class MemberServiceImpl implements MemberService {
	//@Autowired
	private MemberDAO dao;
	
//	public MemberServiceImpl(MemberDAO dao)
//	{
//		this.dao = dao;
//	}
	
	public void setMemberDAO(MemberDAO dao)
	{
		this.dao=dao;
	}

	public MemberVO memberLogin(MemberVO vo){
		return dao.memberLogin(vo);
	}
	
	public ArrayList memberList(){	
		return dao.memberList();
	}
}
