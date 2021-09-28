package com.mission_everyday.post.BO;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mission_everyday.common.FileManagerService;
import com.mission_everyday.post.DAO.PostDAO;
import com.mission_everyday.post.Model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	//글 타임라인 조회
	public List<Post> getPostList(int missionId){
		return postDAO.selectPostList(missionId);
	}
	
	//글쓰기
	public int addPost(int userId, String userName, int missionId, String missionName, String content, MultipartFile file, Date missionStartDate, Date missionFinishDate, int missionPeriod) {
		
		String imgPath = null;
		
		try {
			imgPath = fileManagerService.saveFile(userId, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postDAO.insertPost(userId, userName, missionId, missionName, content, imgPath, missionStartDate, missionFinishDate, missionPeriod);
	}
	
	//글 수정
	public int updatePost(int id, int userId, String content, MultipartFile file) {
		
		String imgPath = null;
		
		try {
			imgPath = fileManagerService.saveFile(userId, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postDAO.updatePost(id, userId, content, imgPath);
	}
	
	//글 삭제
	public int deletePost(int id, int userId) {
		return postDAO.deletePost(id, userId);
	}
	
	// 내가 쓴 글 조회 (마이페이지)
	public List<Post> getPostListByUserId(int userId){
		return postDAO.selectPostListByUserId(userId);
	};
	
	// 내가 쓴 글 미션별 현황 조회 (마이 페이지)
	public List<Post> getPostListByUserIdAndMissionId(int userId, int missionId){
		return postDAO.selectPostListByUserIdAndMissionId(userId, missionId);
	};
	
	// 내가 수정할 글 조회
	public Post getPostByUserIdAndPostId(int userId, int id){
		return postDAO.selectPostByUserIdAndPostId(userId, id);
	};

}
