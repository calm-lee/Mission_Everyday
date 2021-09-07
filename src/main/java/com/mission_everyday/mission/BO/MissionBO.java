package com.mission_everyday.mission.BO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.mission.DAO.MissionDAO;
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
}