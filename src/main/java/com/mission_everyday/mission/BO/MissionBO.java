package com.mission_everyday.mission.BO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.mission.DAO.MissionDAO;
import com.mission_everyday.mission.Model.Member;
import com.mission_everyday.mission.Model.Mission;

@Service
public class MissionBO {

	@Autowired
	private MissionDAO missionDAO;

	@Autowired
	private MissionBO missionBO;

	// 미션 리스트 가져오기
	public List<Mission> getMissionListByCategoryId(int categoryId) {
		return missionDAO.selectMissionListByCategoryId(categoryId);
	}

	// 카테고리 이름만 가져오기
	public Mission getCategoryNameOnly(int categoryId) {
		return missionDAO.selectCategoryNameOnly(categoryId);
	}

	// 개별 미션 가져오기
	public Mission getMissionByMissionId(int id) {
		return missionDAO.selectMissionByMissionId(id);
	}

	// 미션 가입하기
	public int addUserIntoMission(int categoryId, int missionId, String missionName, Date missionStartDate,
			Date missionFinishDate, int missionPeriod, String missionImage, int userId, String userName) {
		return missionDAO.insertUserIntoMission(categoryId, missionId, missionName, missionStartDate, missionFinishDate,
				missionPeriod, missionImage, userId, userName);
	}

	// 미션 가입한 유저 수 가져오기
	public int getMemberCountByMissionId(int missionId) {
		return missionDAO.selectMemberCountByMissionId(missionId);
	}

	// 미션 가입한 유저 수 가져오기
	public List<Member> getMemberListByMissionId(int missionId) {
		return missionDAO.selectMemberListByMissionId(missionId);
	}

	// 미션에 가입했는지 확인하기
	public int getExistedMember(int missionId, int userId) {
		return missionDAO.selectExistedMember(missionId, userId);
	}

	// 미션 탈퇴하기
	public int deleteMemberFromMission(int missionId, int userId) {
		return missionDAO.deleteMemberFromMission(missionId, userId);
	}

	// 종료된 미션 여부
	public String CheckExpiredMission(int missionId) throws ParseException {

		String checkMissionAvailable = null;

		// 오늘날짜 가져오기
		Calendar today = Calendar.getInstance();

		// format 통일하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_sdf = sdf.format(today.getTime()); // Calendar -> String
		Date todayDate = sdf.parse(today_sdf); // String -> Date

		// 미션 종료일자 가져오기
		Mission mission = missionBO.getMissionByMissionId(missionId);
		Date missionFinishDate = mission.getMissionFinishDate();

		if (missionFinishDate.compareTo(todayDate) == -1) { // 미션종료일자가 오늘보다 과거일 때
			return checkMissionAvailable = "closed";
		} else { // 미션 종료일자가 아직 남았을 때
			return checkMissionAvailable = "open";
		}

	}

	// 종료된 미션 여부 - 카테고리 상세 페이지
	public List<String> CheckExpiredMissionInCategory(int categoryId) throws ParseException {

		List<String> checkMissionAvailable = null;

		// 오늘날짜 가져오기
		Calendar today = Calendar.getInstance();

		// format 통일하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_sdf = sdf.format(today.getTime()); // Calendar -> String
		Date todayDate = sdf.parse(today_sdf); // String -> Date

		// 미션 종료일자 가져오기
		List<Mission> missionList = missionBO.getMissionListByCategoryId(categoryId);
		String check  = null;
		
		for (Mission mission : missionList) {
			Date missionFinishDate = mission.getMissionFinishDate();

			if (missionFinishDate.compareTo(todayDate) == -1) { // 미션종료일자가 오늘보다 과거일 때
				check = "closed";
			} else { // 미션 종료일자가 아직 남았을 때
				check ="open";
			}
			checkMissionAvailable.add(check);
		}
		return checkMissionAvailable;
	}
}