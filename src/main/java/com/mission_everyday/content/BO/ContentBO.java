package com.mission_everyday.content.BO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.comment.BO.CommentBO;
import com.mission_everyday.comment.Model.Comment;
import com.mission_everyday.content.Model.Content;
import com.mission_everyday.post.BO.LikeBO;
import com.mission_everyday.post.BO.PostBO;
import com.mission_everyday.post.Model.Like;
import com.mission_everyday.post.Model.Post;

@Service
public class ContentBO {

	@Autowired
	private PostBO postBO;

	@Autowired
	private CommentBO commentBO;

	@Autowired
	private LikeBO likeBO;
	
	
	// 미션 타임라인에서 조회하기
	public List<Content> getContentList(Integer userId, int missionId) {

		List<Content> contentList = new ArrayList<>();
		List<Post> postList = postBO.getPostList(missionId);

		for (Post post : postList) {

			Content content = new Content();

			// 1. content에 현재 포스트 넣기
			content.setPost(post);

			// 2. content에 현재 commentList 넣기
			content.setCommentList(commentBO.getCommentList(post.getId()));

			// 3. content에 현재 좋아요 상태 넣기
			content.setFilledLike(likeBO.existedLike(userId, post.getId()));

			// 4. content에 현재 좋아요 개수 넣기
			content.setLikeCount(likeBO.getLikeCountByPostId(post.getId()));

			contentList.add(content);
		}

		return contentList;
	}
}