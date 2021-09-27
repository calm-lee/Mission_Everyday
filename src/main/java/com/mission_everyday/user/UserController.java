package com.mission_everyday.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	// 로그인하기
	@RequestMapping("/sign_in")
	public String SignIn(Model model) {
		model.addAttribute("viewName", "user/sign_in");
		return "layout/template";
	}
	
	// 회원가입
	@RequestMapping("/sign_up")
	public String SignUp(Model model) {
		model.addAttribute("viewName", "user/sign_up");
		return "layout/template";
	}
	
	// 로그아웃하기
	@RequestMapping("/sign_out")
	public String SignOut(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");

		model.addAttribute("viewName", "mission/category");
		return "redirect:/user/sign_in";
	}
}
