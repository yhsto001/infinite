package com.dambeetech.first.user.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dambeetech.first.user.model.service.UserService;
import com.dambeetech.first.user.model.vo.User;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("enrollpage.do")
	public String home(Locale locale, Model model) {
	
		return "user/enrollpage";
	}
	
	//회원가입
	@RequestMapping("enroll.do")
	public String enroll(Locale locale, Model model, User vo) {
		int enroll = userService.enroll(vo);
		return "user/login";
	}
	
	//로그인
	@RequestMapping("login.do")
	@ResponseBody
	public User loginSuccess(HttpServletRequest request, Model model, User vo) {
		
		User login = userService.login(vo);
		

		if(login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user",login);
		}
		return login;
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		 session.invalidate();
		return "redirect:main.do";
	}
	
	@RequestMapping("htmain.do")
	public String htmain(HttpSession session, Model model) {
		 
		return "common/main";
	}
}
