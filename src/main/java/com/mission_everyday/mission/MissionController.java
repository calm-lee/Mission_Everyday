package com.mission_everyday.mission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mission_everyday.mission.BO.MissionBO;
import com.mission_everyday.mission.Model.Mission;

@Controller
@RequestMapping("/mission")
public class MissionController {
	
	@Autowired
	private MissionBO missionBO;
	
	// 미션 상세 페이지 가져오기
	@RequestMapping("/mission_detail/{categoryId}") //@PathVariable 사용
	public String missionDetail(@PathVariable(value="categoryId") int categoryId, Model model) {

		List<Mission> missionList = missionBO.getMissionByCategoryId(categoryId); // 미션 리스트 가져오기
		Mission mission = missionBO.getCategoryNameOnly(categoryId); //박스 헤더용 카테고리 이름만 가져올 메소드
		
		model.addAttribute("missionList", missionList);
		model.addAttribute("mission", mission);
		model.addAttribute("viewName", "mission/category_detail");
		return "layout/template";
		
	}
	
}
