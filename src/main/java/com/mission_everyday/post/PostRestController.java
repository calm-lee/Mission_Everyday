package com.mission_everyday.post;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mission_everyday.post.BO.LikeBO;
import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Post;

@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	@Autowired
	private LikeBO likeBO;
	
	
	//글쓰기
	@RequestMapping("/create")
	public Map<String, Object> createPost(
			@RequestParam("missionId") int missionId
			, @RequestParam("missionName") String missionName
			, @RequestParam("missionStartDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date missionStartDate
			, @RequestParam("missionFinishDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date missionFinishDate
			, @RequestParam("missionPeriod") int missionPeriod			
			, @RequestParam(value="content", required=false) String content
			, @RequestParam("file") MultipartFile file
			, HttpServletRequest request
			, Model model) throws ParseException{
		
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		
		Map<String, Object> result = new HashMap<>();
				
		int row = postBO.addPost(userId, userName, missionId, missionName, content, file, missionStartDate, missionFinishDate, missionPeriod);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		model.addAttribute("result", result);
		
		return result;				
	}
	
	//글 수정
	@RequestMapping("/update")
	public Map<String, Object> updatePost(
			@RequestParam("id") int id
			, @RequestParam(value="content", required=false) String content
			, @RequestParam(value="file", required=false) MultipartFile file
			, HttpServletRequest request
			, Model model){
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		int row = postBO.updatePost(id, userId, content, file);
		
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		model.addAttribute("result", result);
		
		return result;				
	}
	
	// 글 삭제
	@RequestMapping("/delete")
	public Map<String, Object> deletePost(
			@RequestParam("id") int id
			, HttpServletRequest request
			, Model model){
		
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		
		
		Map<String, Object> result = new HashMap<>();
		
		int row = postBO.deletePost(id, userId);
		
		if(row > 0) {
			likeBO.deleteLikeByPostId(id);
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		model.addAttribute("result", result);
		
		return result;
	}
	
	
	// 좋아요 반영
	@RequestMapping("/like_status")
	public Map<String, Object> likeStatus(
			@RequestParam("postId") int postId
			, HttpServletRequest request
			, Model model){
		
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		
		Map<String, Object> result = new HashMap<>();
		
		
		if(userId == null) { // 로그인이 안된 상태이면
			result.put("result", "fail"); // 상태 반영 안함
		} else { // 로그인이 된 상태이면
			likeBO.likeStatus(userId, postId); // 좋아요 동작 반영함
			result.put("result", "success");
		}
		
		model.addAttribute("result", result);
		
		return result;
		
	}
	
}
