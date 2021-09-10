package com.mission_everyday.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mission_everyday.post.BO.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	//글쓰기
	@RequestMapping("/create")
	public Map<String, Object> createPost(
			@RequestParam("missionId") int missionId
			, @RequestParam("missionName") String missionName
			, @RequestParam(value="content", required=false) String content
			, @RequestParam("file") MultipartFile file
			, HttpServletRequest request
			, Model model){
		
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		
		Map<String, Object> result = new HashMap<>();
		
		int row = postBO.addPost(userId, userName, missionId, missionName, content, file);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		model.addAttribute("result", result);
		
		return result;				
	}
}
