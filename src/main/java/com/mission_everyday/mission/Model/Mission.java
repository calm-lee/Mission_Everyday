package com.mission_everyday.mission.Model;

import java.util.Date;

public class Mission {

	private int id;
	private int categoryId;
	private String categoryName;
	private String missionName;
	private String missionIntroduction;
	private String missionImage;
	private Date missionStartDate;
	private Date missionFinishDate;
	private int missionPeriod;
	private Date createdAt;
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getMissionIntroduction() {
		return missionIntroduction;
	}
	public void setMissionIntroduction(String missionIntroduction) {
		this.missionIntroduction = missionIntroduction;
	}
	public String getMissionImage() {
		return missionImage;
	}
	public void setMissionImage(String missionImage) {
		this.missionImage = missionImage;
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
