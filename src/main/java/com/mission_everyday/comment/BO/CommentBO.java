package com.mission_everyday.comment.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.comment.DAO.CommentDAO;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	
	// 댓글 쓰기
	public int addComment(int missionId, int postId, String content) {
		return commentDAO.insertComment(missionId, postId, content);
	}
	
	// 댓글 삭제하기
	public int deleteComment(int missionId, int postId, String content) {
		return commentDAO.deleteComment(missionId, postId, content);
	}

}
