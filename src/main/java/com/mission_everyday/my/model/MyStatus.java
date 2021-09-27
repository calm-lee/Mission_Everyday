package com.mission_everyday.my.model;

public class MyStatus {

	// 미션 체크 여부
	private String Status;
	
	// 요일
	private String Mon = "Mon"; 
	private String Tue = "Tue";
	private String Wed = "Wed";
	private String Thu = "Thu";
	private String Fri = "Fri";
	private String Sat = "Sat";
	private String Sun = "Sun";
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

	
	
	
}
