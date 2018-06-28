package com.biz.user;

import java.util.ArrayList;
import java.util.HashMap;

import com.ssu.member.MemberVO;

import oracle.net.aso.e;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberVO vo = new MemberVO();
		vo.setMid("kim");
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(vo);
		vo = (MemberVO)list.get(0);
		System.out.println(vo.getMgubun());
		System.out.println(list.get(0).getMid());
		
		ArrayList<HashMap> list2 = new ArrayList<HashMap>();
		HashMap map = new HashMap();
		map.put("AAA", "KIM");
		map.put("BBB", 26);
		list2.add(map);
		System.out.println(list2.get(0).get("BBB"));
		
	}

}
