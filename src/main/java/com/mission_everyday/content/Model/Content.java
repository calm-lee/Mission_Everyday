package com.mission_everyday.content.Model;

import java.util.List;

import com.mission_everyday.comment.Model.Comment;
import com.mission_everyday.post.Model.Post;

public class Content {

	private Post Post; //포스트
	private List<Comment> CommentList;//댓글리스트
	private boolean filledLike; //좋아요 눌렀는지 안 눌렀는지
	private int likeCount; //좋아요 개수
	
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public List<Comment> getCommentList() {
		return CommentList;
	}
	public void setCommentList(List<Comment> commentList) {
		CommentList = commentList;
	}
	public boolean isFilledLike() {
		return filledLike;
	}
	public void setFilledLike(boolean filledLike) {
		this.filledLike = filledLike;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	
}
