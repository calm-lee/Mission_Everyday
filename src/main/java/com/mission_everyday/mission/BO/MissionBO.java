package com.mission_everyday.mission.BO;

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
	
	//미션 리스트 가져오기
	public List<Mission> getMissionByCategoryId(int categoryId) {
		return missionDAO.selectByCategoryId(categoryId);
	}
	
	//카테고리 이름만 가져오기
	public Mission getCategoryNameOnly(int categoryId) {
		return missionDAO.selectCategoryNameOnly(categoryId);
	}
	
	//개별 미션 가져오기
	public Mission getMissionByMissionId(int id) {
		return missionDAO.selectMissionByMissionId(id);
	}
	
	//미션 가입하기
	public int addUserIntoMission(int missionId, String missionName, int userId, String userName) {
		return missionDAO.insertUserIntoMission(missionId, missionName, userId, userName);
	}
	
	//미션 가입한 유저 수 가져오기
	public int getMemberCountByMissionId(int missionId) {
		return missionDAO.selectMemberCountByMissionId(missionId);
	}
	
	//미션 가입한 유저 수 가져오기
	public List<Member> getMemberByMissionId(int missionId) {
		return missionDAO.selectMemberByMissionId(missionId);
	}
	
	//미션 탈퇴하기
	public int deleteMemberFromMission(int missionId, int userId) {
		return missionDAO.deleteMemberFromMission(missionId, userId);
	}
}