package com.mission_everyday.my.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.my.model.MyMission;

@Repository
public interface MyDAO {

	public List<MyMission> selectMyMissionListByUserId(@Param("userId") int userId);
	
	public MyMission selectMyMissionByUserIdAndMissionId(@Param("userId") int userId, @Param("missionId") int missionId);

}
