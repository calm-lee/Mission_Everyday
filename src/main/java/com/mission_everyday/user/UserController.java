package com.mission_everyday.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
