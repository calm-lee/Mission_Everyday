package com.mission_everyday.post.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.post.Model.Post;

@Repository
public interface PostDAO {

	//글 타임라인 조회
	public List<Post> selectPostList(int missionId);
	
	//글쓰기
	public int insertPost(@Param("userId") int userId, @Param("userName") String userName, @Param("missionId") int missionId, @Param("missionName") String missionName, @Param("content") String content, @Param("imgPath") String imgPath);

	//글 수정
	public int updatePost(@Param("id") int id, @Param("userId") int userId, @Param("content") String content, @Param("imgPath") String imgPath);
	
	//글 삭제
	public int deletePost(@Param("id") int id, @Param("userId") int userId);
}
