package com.mission_everyday.comment.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {

	// 댓글 쓰기
	public int insertComment(@Param("missionId") int missionId, 
			@Param("postId") int postId, 
			@Param("content") String content);
	
	// 댓글 삭제하기
	public int deleteComment(@Param("missionId") int missionId, 
			@Param("postId") int postId, 
			@Param("content") String content);
}
