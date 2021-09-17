package com.mission_everyday.my.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.my.dao.MyDAO;
import com.mission_everyday.my.model.MyMission;

@Service
public class MyBO {

	@Autowired
	private MyDAO myDAO;
	
	// 가입한 미션 목록 가져오기
	public List<MyMission> getMyMissionListByUserId(int userId){
		return myDAO.selectMyMissionListByUserId(userId);
	}
}
