package com.mission_everyday.user.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mission_everyday.user.Model.User;

@Repository
public interface UserDAO {

	// 로그인
	public User selectUserByLoginIdAndPassword(@Param("loginId") String loginId, @Param("password") String password);
	
	// 아이디 중복확인하기
	public int selectUserByLoginId(@Param("loginId") String loginId);
	
	// 회원가입하기
	public int insertUser(@Param("loginId") String loginId, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("email") String email);
}
