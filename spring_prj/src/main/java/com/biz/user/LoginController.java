package com.biz.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.user.MemberService;

@Controller //어노테이션, 일종의 new, static 역할, 메모리에 올라감
public class LoginController{
	@Autowired //spring 3.0에서 어노테이션을 통해 필드로 자동으로 받아짐
	private MemberService memberService;
//	public LoginController(MemberServiceImpl svc){
//		this.memberService = svc;
//	}
	
	//메소드 명이 handlerRequest가 아니어도 해당 주소가 들어오면 바로 아래 메소드가 실행됨
	@RequestMapping(value = "/slogin")
	public ModelAndView handlerRequest(HttpServletRequest request, HttpServletResponse response) {

		//1. 사용자 입력정보(id,pw) 추출 코드
		MemberVO vo = new MemberVO(); 
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		
		//2. 사용자 입력 정보 이용 UserVO 객체 조회
		//setter()로 UserService객체 못 받아올 경우 아래 주석풀고 실행
		//---------------------의존성 주입(DI)---------------------
		//MemberService memberService = new MemberServiceImpl();
		//-----------------------------------------------------
		vo = memberService.memberLogin(vo);
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
		
//		String viewName="";
//		if(!vo.getMname().equals("")) {
//			HttpSession session = request.getSession();
//			session.setAttribute("SESS_ID", vo.getMid());
//			session.setAttribute("SESS_NAME", vo.getMname());
//			viewName = "member_main";
//		} else {
//			viewName = "member_login";
//		} 
//		return viewName;
		
		ModelAndView mav = new ModelAndView();
		
		if(vo.getMname() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("SS_NAME", vo.getMname());
			session.setAttribute("SS_GUBUN", vo.getMgubun());
			session.setAttribute("SS_POINT", 10000);
			
			if(vo.getMgubun().equals("u")) {
				mav.addObject("username", vo.getMname());
				mav.setViewName("member_main");
			} else if(vo.getMgubun().equals("a")) {
				ArrayList list = memberService.memberList();
				mav.addObject("LVL", list);
				mav.setViewName("admin_main");
			}
		} else {
			mav.setViewName("member_login");
		}
		
		return mav;
	}
}
