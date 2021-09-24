package com.mission_everyday.my.model;

import com.mission_everyday.mission.Model.Mission;
import com.mission_everyday.post.Model.Post;

public class MyStatus {
	
	private Post Post; //포스트
	private Mission mission; //미션
	
	public Post getPost() {
		return Post;
	}
	public void setPost(Post post) {
		Post = post;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	
	
}
