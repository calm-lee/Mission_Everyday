package com.mission_everyday.post.DAO;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.post.Model.Post;

@Repository
public interface PostDAO {

	//글 타임라인 조회
	public List<Post> selectPostList(int missionId);
	
	//글쓰기
	public int insertPost(@Param("userId") int userId, @Param("userName") String userName, @Param("missionId") int missionId, @Param("missionName") String missionName, @Param("content") String content, @Param("imgPath") String imgPath,  @Param("missionStartDate") Date missionStartDate, @Param("missionFinishDate") Date missionFinishDate, @Param("missionPeriod") int missionPeriod);
	
	//글 수정
	public int updatePost(@Param("id") int id, @Param("userId") int userId, @Param("content") String content, @Param("imgPath") String imgPath);
	
	//글 삭제
	public int deletePost(@Param("id") int id, @Param("userId") int userId);

	//내가 쓴 글 조회 (마이 페이지)
	public List<Post> selectPostListByUserId(@Param("userId") int userId);
		
	//내가 쓴 글 미션별 현황 조회 (마이 페이지)
	public List<Post> selectPostListByUserIdAndMissionId(@Param("userId") int userId, @Param("missionId") int missionId);
	
	//내가 수정할 글 조회
	public Post selectPostByUserIdAndPostId(@Param("userId") int userId, @Param("id") int id);
}
