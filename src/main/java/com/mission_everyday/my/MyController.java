package com.mission_everyday.my;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mission_everyday.my.bo.MyBO;
import com.mission_everyday.my.model.MyMission;

@Controller
@RequestMapping("/my")
public class MyController {

	@Autowired
	private MyBO myBO;
	
	
	// 참여 중인 미션 불러오기
	@RequestMapping("/mission")
	public String SignIn(
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
	
}
