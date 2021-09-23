package com.mission_everyday.post.BO;

import java.io.IOException;
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
	public int addPost(int userId, String userName, int missionId, String missionName, String content, MultipartFile file) {
		
		String imgPath = null;
		
		try {
			imgPath = fileManagerService.saveFile(userId, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postDAO.insertPost(userId, userName, missionId, missionName, content, imgPath);
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

}
