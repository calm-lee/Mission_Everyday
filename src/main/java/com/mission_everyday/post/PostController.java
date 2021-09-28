package com.mission_everyday.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostBO postBO;

	@GetMapping("/update_view")
	public String postUpdateView(
			@RequestParam("id") int id
			, HttpServletRequest request
			, Model model) {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if (userId == null) {
			// 세션에 로그인 아이디가 없다면 로그인이 안된 것이므로 로그인 페이지로 리다이렉트
			return "redirect:/user/sign_in";
		}
		
		Post post = postBO.getPostByUserIdAndPostId(userId, id);
		
		model.addAttribute("post", post);
		model.addAttribute("viewName", "post/post_update");
		
		return "layout/template";
	}
}
