package com.mission_everyday.my;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mission_everyday.content.Model.Content;
import com.mission_everyday.my.bo.MyBO;
import com.mission_everyday.my.model.MyMission;
import com.mission_everyday.my.model.MyStatus;
import com.mission_everyday.post.BO.PostBO;

@Controller
@RequestMapping("/my")
public class MyController {

	@Autowired
	private MyBO myBO;

	@Autowired
	private PostBO postBO;
	
	// 참여 중인 미션 불러오기
	@RequestMapping("/mission")
	public String MyMission(
			HttpServletRequest request, 
			Model model) {
		
		HttpSession session = request.getSession(); //세션 불러오기
		Integer userId = (Integer) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		String userName = (String) session.getAttribute("userName"); //세션상 로그인 아이디 저장
		
		List<MyMission> myMissionList = myBO.getMyMissionListByUserId(userId);
			
		model.addAttribute("viewName", "my/my_mission");
		model.addAttribute("myMissionList", myMissionList);
		return "layout/template";
	}

	// 내가 올린 포스트 조회
	@RequestMapping("/post")
	public String MyPost(
			HttpServletRequest request, 
			Model model) {
		
		HttpSession session = request.getSession(); //세션 불러오기
		Integer userId = (Integer) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		String userName = (String) session.getAttribute("userName"); //세션상 로그인 아이디 저장
		
		List<Content> myContentList = myBO.getContentListByUserId(userId);
		
		model.addAttribute("myContentList", myContentList);
		model.addAttribute("viewName", "my/my_post");
		return "layout/template";
	}
	
	// 참여 중인 미션 불러오기
	@RequestMapping("/status")
	public String MyStatus(
			HttpServletRequest request, 
			Model model) {
		
		HttpSession session = request.getSession(); //세션 불러오기
		Integer userId = (Integer) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		String userName = (String) session.getAttribute("userName"); //세션상 로그인 아이디 저장
		
		List<MyMission> myMissionList = myBO.getMyMissionListByUserId(userId);
			
		model.addAttribute("viewName", "my/my_status");
		model.addAttribute("myMissionList", myMissionList);
		return "layout/template";
	}

	// 내 인증현황 조회
	@RequestMapping("/status/{missionId}")
	public String MyStatusView(
			@PathVariable(value="missionId") int missionId
			,HttpServletRequest request
			,Model model) throws ParseException {
		
		HttpSession session = request.getSession(); //세션 불러오기
		Integer userId = (Integer) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		
		MyMission myMission = myBO.getMyMissionByUserIdAndMissionId(userId, missionId);
		List<MyStatus> myStatusList = myBO.getMyMissionStatus(userId,missionId); // 내 상태 불러오기
		int successCount = myBO.getSuccessCountByUserIdAndMissionId(userId, missionId);
		
		model.addAttribute("myMission", myMission); // 내 미션현황 리스트
		model.addAttribute("myStatusList", myStatusList); // 내 미션현황 리스트
		model.addAttribute("viewName", "my/my_status_detail");
		return "layout/template";
	}
	
}
