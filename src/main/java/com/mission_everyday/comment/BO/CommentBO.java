package com.mission_everyday.comment.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.comment.DAO.CommentDAO;
import com.mission_everyday.comment.Model.Comment;

@Service
public class CommentBO {
	
	@Autowired
	private CommentDAO commentDAO;
	
	
	// 댓글 리스트 불러오기
	public List<Comment> getCommentList(int postId){
		return commentDAO.selectCommentList(postId);
	}
	
	// 댓글 쓰기
	public int addComment(int userId, String userName, int missionId, int postId, String content) {
		return commentDAO.insertComment(userId, userName, missionId, postId, content);
	}
	
	// 댓글 삭제하기 by 댓글 작성자
	public int deleteComment(int id, int userId) {
		return commentDAO.deleteComment(id, userId);
	}
	
	// 댓글 삭제하기 by 글쓴이
	public int deleteCommentByPostId(int postId) {
		return commentDAO.deleteCommentByPostId(postId);
	}
	

}
