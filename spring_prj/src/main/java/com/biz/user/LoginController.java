package com.biz.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.user.MemberService;

// @Controller //어노테이션, 일종의 new, static 역할, 메모리에 올라감
// Controller 클래스를 상속하여 일반 클래스로 만든 경우, servelt-context.xml에서 <bean>로 명시하여 메모리에 올림
// service를 생성자를 통해 받아야 함
// 설정으로 메모리에 생성된 service 객체를 생성자로 넣어줄 수 있도록 명시해야 함

// spring은 컨트롤러를 먼저 찾고, 컨트롤러 필드에 명시된 필요한 서비스와 dao 등을 찾아가는 것임
// 어노테이션을 사용하면 컨트롤러를 찾은 다음 필요에 따라 명시된 어노테이션을 참고하여 필요한 객체들을 찾음(찾기 용이하도록 하는 것)
public class LoginController extends MultiActionController{
	//@Autowired //spring 3.0에서 어노테이션을 통해 필드로 자동으로 받아짐
	private MemberService memberService;
	
	// Controller 클래스를 상속하여 사용할 때 생성자 방식
//	public LoginController(MemberServiceImpl svc){
//		this.memberService = svc;
//	}
	
	// Controller 클래스를 상속하여 사용할 때 setter 방식
	// Autowired는 setter를 대신하는 것임
	// 만약 Autowired를 막아야 하는 상황이라면 setter를 열어둘 것
	public void setMemberService(MemberService memberService)
	{
		this.memberService = memberService;
	}
	
	//@RequestMapping 사용 시, 메소드 명이 handlerRequest가 아니어도 해당 주소가 들어오면 바로 아래 메소드가 실행됨
	//@RequestMapping(value = "/slogin")
	// MultiActionController를 상속받는 경우 해당 주소에서 실행할 메소드를 해당 주소로 이름을 지정하면 됨.
	public ModelAndView slogin(HttpServletRequest request, HttpServletResponse response)
			//throws Exception
	{

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
				mav.setViewName("index");
			}
		} else {
			mav.setViewName("member_login");
		}
		
		return mav;
	}
	
	//@RequestMapping(value = "/slogout")
	public ModelAndView slogout(HttpServletRequest request , HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		session.setMaxInactiveInterval(0);
		ModelAndView mav = new ModelAndView();
		
//		ArrayList list = memberService.memberList();
//		mav.addObject("LVL", list);
		mav.setViewName("index");
		return mav;
	}
}
