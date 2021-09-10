package com.mission_everyday.mission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mission_everyday.mission.BO.MissionBO;
import com.mission_everyday.mission.Model.Member;
import com.mission_everyday.mission.Model.Mission;

@Controller
@RequestMapping("/mission")
public class MissionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MissionBO missionBO;
	
	// 카테고리 상세 페이지 가져오기
	@RequestMapping("/mission_detail/{categoryId}") //@PathVariable 사용
	public String categoryDetail(@PathVariable(value="categoryId") int categoryId, Model model) {

		List<Mission> missionList = missionBO.getMissionByCategoryId(categoryId); // 미션 리스트 가져오기
		Mission mission = missionBO.getCategoryNameOnly(categoryId); //박스 헤더용 카테고리 이름만 가져올 메소드
		
		model.addAttribute("missionList", missionList);
		model.addAttribute("mission", mission);
		model.addAttribute("viewName", "mission/category_detail");
		return "layout/template";
		
	}
	
	// 미션 타임라인 가져오기
	@RequestMapping("/{categoryId}/{id}") //@PathVariable 사용
	public String missionTimeline(@PathVariable(value="categoryId") int categoryId
			,@PathVariable(value="id") int id //missionId
			,HttpServletRequest request
			,Model model) {
		
		HttpSession session = request.getSession(); //세션 불러오기
		int userId = (int) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		
		Mission mission  = missionBO.getMissionByMissionId(id); //미션 id에 맞는 미션 정보 가져오기
		int memberCount = missionBO.getMemberCountByMissionId(id); // 미션에 가입한 멤버 인원수 가져오기
		
		int missionId = id; 
		int member = missionBO.getExistedMember(missionId, userId); // 미션 가입했는지 여부 가져옴
		Map<String, String> result = new HashMap<>();
		
		if(member > 0) {
			result.put("check", "member");
		} else {
			result.put("check", "no-member");
		}
		
		model.addAttribute("mission", mission); //미션정보
		model.addAttribute("memberCount", memberCount); // 가입 멤버 수
		model.addAttribute("result", result); // 미션 가입 여부 정보 (가입/탈퇴버튼 노출 목적)
		model.addAttribute("viewName", "mission/timeline");
		return "layout/template";		
	}
	
}
