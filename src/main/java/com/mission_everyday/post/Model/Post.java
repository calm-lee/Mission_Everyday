package com.mission_everyday.post.Model;

import java.util.Date;

public class Post {
	private int id;
	private int userId;
	private String userName;
	private int missionId;
	private String missionName;
	private String content;
	private String imgPath;
	private Date missionStartDate;
	private Date missionFinishDate;
	private int missionPeriod;
	private Date createdAt;
	private Date updatedAt;
	
	public int getId() {
		return id;
	}
	public Date getMissionStartDate() {
		return missionStartDate;
	}
	public void setMissionStartDate(Date missionStartDate) {
		this.missionStartDate = missionStartDate;
	}
	public Date getMissionFinishDate() {
		return missionFinishDate;
	}
	public void setMissionFinishDate(Date missionFinishDate) {
		this.missionFinishDate = missionFinishDate;
	}
	public int getMissionPeriod() {
		return missionPeriod;
	}
	public void setMissionPeriod(int missionPeriod) {
		this.missionPeriod = missionPeriod;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
