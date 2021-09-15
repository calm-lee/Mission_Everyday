package com.mission_everyday.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mission_everyday.comment.BO.CommentBO;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, Object> createComment(@RequestParam("missionId") int missionId, 
			@RequestParam("postId") int postId, 
			@RequestParam("content") String content,
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");		
		
		Map<String, Object> result = new HashMap<>();
		
		int row = commentBO.addComment(userId, userName, missionId, postId, content);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	

	// 댓글 삭제하기
	@RequestMapping("/delete")
	public Map<String, Object> deleteComment(
			@RequestParam("id") int id,
			HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");		
		
		Map<String, Object> result = new HashMap<>();
		
		int row = commentBO.deleteComment(id, userId);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}

