package com.biz.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LogoutController {
	@RequestMapping(value = "/slogout")
	public String handlerRequest(HttpServletRequest request , HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		session.setMaxInactiveInterval(0);
		return "member_login";
	}
}
