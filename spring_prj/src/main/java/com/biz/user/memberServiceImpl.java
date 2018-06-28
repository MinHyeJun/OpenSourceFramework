package com.biz.user;

import java.util.ArrayList;

public class memberServiceImpl implements memberService {

	public MemberVO memberLogin(MemberVO vo){
		MemberDAO memberDAO = new MemberDAO();	
		return memberDAO.memberLogin(vo);
	}
	
	public ArrayList memberList(){
		MemberDAO memberDAO = new MemberDAO();	
		return memberDAO.memberList();
	}
}
