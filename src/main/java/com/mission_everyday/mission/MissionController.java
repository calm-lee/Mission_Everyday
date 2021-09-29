package com.mission_everyday.mission;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.mission_everyday.content.BO.ContentBO;
import com.mission_everyday.content.Model.Content;
import com.mission_everyday.mission.BO.MissionBO;
import com.mission_everyday.mission.Model.Mission;
import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Post;

@Controller
@RequestMapping("/mission")
public class MissionController {

	@Autowired
	private ContentBO contentBO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MissionBO missionBO;
	
	@Autowired
	private PostBO postBO;
	
	private Content content;
	
	// 카테고리 상세 페이지 가져오기
	@RequestMapping("/category/{categoryId}") //@PathVariable 사용
	public String categoryDetail(@PathVariable(value="categoryId") int categoryId, Model model) throws ParseException {

		List<Mission> missionList = missionBO.getMissionListByCategoryId(categoryId); // 미션 리스트 가져오기
		Mission mission = missionBO.getCategoryNameOnly(categoryId); //박스 헤더용 카테고리 이름만 가져올 메소드	
		
		// 오늘날짜 가져오기
		Calendar today = Calendar.getInstance();

		// format 통일하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_sdf = sdf.format(today.getTime()); // Calendar -> String
		Date todayDate = sdf.parse(today_sdf); // String -> Date
		
		
		model.addAttribute("missionList", missionList);
		model.addAttribute("mission", mission);
		model.addAttribute("today", todayDate);
		model.addAttribute("viewName", "mission/category_detail");
		return "layout/template";
		
	}
	
	// 미션 타임라인 가져오기
	@RequestMapping("/mission_club/{id}") //@PathVariable 사용
	public String missionTimeline(
			@PathVariable(value="id") int missionId
			,HttpServletRequest request
			,Model model) throws ParseException {
		
		HttpSession session = request.getSession(); //세션 불러오기
		Integer userId = (Integer) session.getAttribute("userId"); //세션상 로그인 아이디 저장
		String userName = (String) session.getAttribute("userName"); //세션상 로그인 아이디 저장
		
		if (userId == null) {
			// 세션에 로그인 아이디가 없다면 로그인이 안된 것이므로 로그인 페이지로 리다이렉트
			return "redirect:/user/sign_in";
		}
		
		Mission mission  = missionBO.getMissionByMissionId(missionId); //미션 id에 맞는 미션 정보 가져오기
		int memberCount = missionBO.getMemberCountByMissionId(missionId); // 미션에 가입한 멤버 인원수 가져오기
		List<Content> contentList = contentBO.getContentList(userId, missionId); // 미션 타임라인 조회용
		List<Post> postList = postBO.getPostList(missionId);// 포스트 모달 조회용
		
		Map<String, String> result = new HashMap<>();
		
		int member = missionBO.getExistedMember(missionId, userId); // 미션 가입했는지 여부 가져옴
		if(member > 0) {
			result.put("check", "member");
		} else {
			result.put("check", "no-member");
		}
		
		String checkMissionAvailable = missionBO.CheckExpiredMission(missionId);
		
		model.addAttribute("mission", mission); //미션정보
		model.addAttribute("memberCount", memberCount); // 가입 멤버 수
		model.addAttribute("result", result); // 미션 가입 여부 정보 (가입/탈퇴버튼 노출 목적)
		model.addAttribute("contentList", contentList); // 타임라인 컨텐트 리스트
		model.addAttribute("checkMissionAvailable", checkMissionAvailable); // 종료된 미션인지 체크
		model.addAttribute("viewName", "mission/timeline");
		return "layout/template";	
		
	}
	
}
