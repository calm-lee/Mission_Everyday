package com.mission_everyday.comment.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.comment.Model.Comment;

@Repository
public interface CommentDAO {
	
	// 댓글 리스트 가져오기
	public List<Comment> selectCommentList(int postId);

	// 댓글 쓰기
	public int insertComment(@Param("missionId") int missionId, 
			@Param("postId") int postId, 
			@Param("content") String content);
	
	// 댓글 삭제하기 by 댓글 작성자
	public int deleteComment(@Param("missionId") int missionId, 
			@Param("postId") int postId, 
			@Param("content") String content);
	
	// 댓글 삭제하기 by 글쓴이
	public int deleteCommentByPostId(int postId);
}
