package com.mission_everyday.my.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mission_everyday.my.bo.MyBO;

public class MyMission {
	
	private int categoryId;
	private int missionId;
	private String missionName;
	private String missionImage;
	private int userId;
	private String userName;
	private Date missionStartDate;
	private Date missionFinishDate;
	private int missionPeriod;
	private Date createdAt;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getMissionImage() {
		return missionImage;
	}

	public void setMissionImage(String missionImage) {
		this.missionImage = missionImage;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
