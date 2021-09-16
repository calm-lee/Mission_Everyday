package com.mission_everyday.mission.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.mission.Model.Member;
import com.mission_everyday.mission.Model.Mission;

@Repository
public interface MissionDAO {

	//미션 리스트 가져오기
	public List<Mission> selectMissionListByCategoryId(@Param("categoryId") int categoryId);

	//카테고리 이름 가져오기
	public Mission selectCategoryNameOnly(@Param("categoryId") int categoryId);

	//개별 미션 가져오기
	public Mission selectMissionByMissionId(int id);
	
	//미션 가입하기
	public int insertUserIntoMission(@Param("missionId") int missionId, @Param("missionName") String missionName,
			@Param("userId") int userId, @Param("userName") String userName);
	
	//미션 가입한 유저 수 가져오기
	public int selectMemberCountByMissionId(int missionId);
	
	//미션 가입한 유저 정보 가져오기
	public List<Member> selectMemberListByMissionId(@Param("missionId") int missionId);
	
	
	//미션에 가입했는지 확인하기
	public int selectExistedMember(@Param("missionId") int missionId, @Param("userId") int userId);
	
	//미션 탈퇴하기
	public int deleteMemberFromMission(@Param("missionId") int missionId, @Param("userId") int userId);
}
