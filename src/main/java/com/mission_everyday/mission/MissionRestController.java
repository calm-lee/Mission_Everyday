package com.mission_everyday.mission;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mission_everyday.mission.BO.MissionBO;

@RestController
@RequestMapping("/mission")
public class MissionRestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MissionBO missionBO;
	
	@PostMapping("/join")
	public Map<String, Object> joinIn(@RequestParam("categoryId") int categoryId, @RequestParam("missionId") int missionId, @RequestParam("missionName") String missionName, @RequestParam("missionImage") String missionImage,HttpServletRequest request) {
		
		HttpSession session = request.getSession(); //세션 불러오기
		
		int userId = (int) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		String userName = (String) session.getAttribute("userName"); //세션상 로그인 유저이름 저장
		
		Map<String, Object> result = new HashMap<String,Object>();
		
		int row = missionBO.addUserIntoMission(categoryId,missionId,missionName,missionImage,userId,userName);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@PostMapping("/out")
	public Map<String,Object> joinOut(@RequestParam("missionId") int missionId, Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession(); //세션 불러오기		
		int userId = (int) session.getAttribute("userId"); //세션상 로그인 아이디 저장
	
		Map<String, Object> result = new HashMap<String,Object>();
		
		int row = missionBO.deleteMemberFromMission(missionId, userId);
		
		if(row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
