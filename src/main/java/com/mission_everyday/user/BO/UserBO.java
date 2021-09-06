package com.mission_everyday.user.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission_everyday.user.DAO.UserDAO;
import com.mission_everyday.user.Model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	// 로그인
	public User getUserByloginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
	
	// 중복확인
	public int getExistedUser(String loginId) {
		return userDAO.selectUserByLoginId(loginId);
	}
	
	// 회원가입
	public int addUser(String loginId, String password, String name, String email) {
		return userDAO.insertUser(loginId, password, name, email);
	}
	
}
