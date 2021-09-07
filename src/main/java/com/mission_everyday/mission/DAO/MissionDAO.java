package com.mission_everyday.mission.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.mission.Model.Mission;

@Repository
public interface MissionDAO {

	public List<Mission> selectByCategoryId(@Param("categoryId") int categoryId);

	public Mission selectCategoryNameOnly(@Param("categoryId") int categoryId);
}
