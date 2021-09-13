package com.mission_everyday.post.BO;

import org.springframework.beans.factory.annotation.Autowired;

import com.mission_everyday.post.DAO.LikeDAO;

public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	
	// 현재 내가 좋아요 누른 상태 여부
	public boolean existedLike(Integer userId, int postId) {
		
		if(userId == null) { // 아이디 로그인 안 되어있는 상태면 
			return false; // false로 조회 안됨
		}
		
		int count = likeDAO.selectLike(userId, postId); // 로그인 되어 있는 경우 좋아요 컬럼 조회
	
		return count > 0 ? true : false; // 좋아요 개수가 0보다 크면 true
	}
	
	// 좋아요 추가/취소 동작 메소드
	public void likeStatus(Integer userId, int postId) {
		
		boolean existedLike = existedLike(userId, postId);
		
		if(existedLike == true) { // 좋아요 이미 눌렀으면
			likeDAO.deleteLikeByUserIdOrPostId(userId, postId); // 눌렀을 때 좋아요 취소
		} else { // 좋아요 안 누른 상태이면 (false)
			likeDAO.insertLike(userId, postId); // 좋아요 추가
		}
	
	}
	
	// 좋아요 개수 구하기
	public int getLikeCountByPostId(int postId) {
		return likeDAO.selectLike(null, postId);
	}
	
	// 글 작성자가 댓글 포함한 콘텐트 모두 삭제할 때 (postId만 필요)
	public void deleteLikeByPostId(int postId) {
		likeDAO.deleteLikeByPostId(postId);
	}
	
}
