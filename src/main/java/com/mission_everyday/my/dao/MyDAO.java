package com.mission_everyday.my.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.my.model.MyMission;

@Repository
public interface MyDAO {

	public List<MyMission> selectMyMissionListByUserId(@Param("userId") int userId);

}
