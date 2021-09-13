package com.mission_everyday.post.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {

	//글쓰기
	public int insertPost(@Param("userId") int userId, @Param("userName") String userName, @Param("missionId") int missionId, @Param("missionName") String missionName, @Param("content") String content, @Param("imgPath") String imgPath);

	//글 수정
	public int updatePost(@Param("id") int id, @Param("userId") int userId, @Param("content") String content, @Param("imgPath") String imgPath);
	
	//글 삭제
	public int deletePost(@Param("id") int id, @Param("userId") int userId);
}
