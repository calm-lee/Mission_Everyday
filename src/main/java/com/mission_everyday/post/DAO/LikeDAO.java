package com.mission_everyday.post.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	//좋아요 추가
	public void insertLike(@Param("userId") Integer userId, @Param("postId") int postId);
	
	//좋아요 취소
	public void deleteLikeByUserIdOrPostId(@Param("userId") Integer userId, @Param("postId") int postId);

	// 좋아요 불러오기
	public int selectLike(@Param("userId") Integer userId, @Param("postId") int postId);
	
	//좋아요 삭제 (댓글쓴이 아닌 글쓴이가 피드 전체 삭제하는 경우)
	public void deleteLikeByPostId(@Param("postId") int postId);
	
}
