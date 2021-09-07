package com.mission_everyday.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mission")
public class CategoryController {

	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("viewName", "mission/category");
		return "layout/template";
	}
	
}
