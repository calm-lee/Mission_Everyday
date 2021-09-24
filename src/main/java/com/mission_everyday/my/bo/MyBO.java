package com.mission_everyday.my.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.comment.BO.CommentBO;
import com.mission_everyday.content.Model.Content;
import com.mission_everyday.my.dao.MyDAO;
import com.mission_everyday.my.model.MyMission;
import com.mission_everyday.my.model.MyStatus;
import com.mission_everyday.post.BO.LikeBO;
import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Post;

@Service
public class MyBO {

	@Autowired
	private MyDAO myDAO;
	
	@Autowired
	private PostBO postBO;

	@Autowired
	private CommentBO commentBO;

	@Autowired
	private LikeBO likeBO;
	
	// 가입한 미션 목록 가져오기
	public List<MyMission> getMyMissionListByUserId(int userId){
		return myDAO.selectMyMissionListByUserId(userId);
	}
		
	// 내가 쓴 글 조회하기
	public List<Content> getContentListByUserId(int userId) {

		List<Content> myContentList = new ArrayList<>();
		List<Post> myPostList = postBO.getPostListByUserId(userId);

		for (Post post : myPostList) {

			Content content = new Content();

			// 1. content에 현재 포스트 넣기
			content.setPost(post);

			// 2. content에 현재 commentList 넣기
			content.setCommentList(commentBO.getCommentList(post.getId()));

			// 3. content에 현재 좋아요 상태 넣기
			content.setFilledLike(likeBO.existedLike(userId, post.getId()));

			// 4. content에 현재 좋아요 개수 넣기
			content.setLikeCount(likeBO.getLikeCountByPostId(post.getId()));

			myContentList.add(content);
		}

		return myContentList;
	}
	
	/*
	 * // 내 성공현황 조회하기 public List<MyStatus> getMyStatusByUserId(int userId) {
	 * 
	 * List<Content> myStatusList = new ArrayList<>(); List<Post> myPostList =
	 * postBO.getPostListByUserId(userId);
	 * 
	 * for (Post post : myPostList) {
	 * 
	 * MyStatus myStatus = new MyStatus();
	 * 
	 * // 1. myStatus에 현재 포스트 넣기 myStatus.setPost(post);
	 * 
	 * // 2. myStatus에 현재 미션 넣기 myStatus.setMission(df);
	 * myStatus.setCommentList(commentBO.getCommentList(post.getId()));
	 * 
	 * // 3. content에 현재 좋아요 상태 넣기 content.setFilledLike(likeBO.existedLike(userId,
	 * post.getId()));
	 * 
	 * // 4. content에 현재 좋아요 개수 넣기
	 * content.setLikeCount(likeBO.getLikeCountByPostId(post.getId()));
	 * 
	 * myContentList.add(content); }
	 * 
	 * return myContentList; }
	 */
}
