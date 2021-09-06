package com.mission_everyday.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/sign_up")
	public String SignUp(Model model) {
		model.addAttribute("viewName", "sign_up");
		return "layout/template";
	}
	
}
