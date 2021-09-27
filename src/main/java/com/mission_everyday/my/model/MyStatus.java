package com.mission_everyday.my.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.mission_everyday.my.bo.MyBO;

public class MyStatus {
	
	// 미션 체크 여부 (String)
	private String status;
	
	// 미션 체크 여부 (int)
	private int successCount;
	private int failCount;
	private int blankCount;	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public int getBlankCount() {
		return blankCount;
	}
	public void setBlankCount(int blankCount) {
		this.blankCount = blankCount;
	}

	
}
