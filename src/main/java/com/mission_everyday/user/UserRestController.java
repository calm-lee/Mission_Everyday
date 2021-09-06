package com.mission_everyday.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mission_everyday.common.EncryptUtils;
import com.mission_everyday.user.BO.UserBO;
import com.mission_everyday.user.Model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	//로그인하기
	@RequestMapping("/sign_in_check")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId, 
			@RequestParam("password") String password,
			HttpServletRequest request
			){
		Map<String, Object> result = new HashMap<>();
	
		//password 암호화해서 조회
		String encrpytedPassword = EncryptUtils.md5(password);
		
		User user = userBO.getUserByloginIdAndPassword(loginId, encrpytedPassword);
		
		if(user != null) {
			
			HttpSession session = request.getSession(); // 세션 불러오기
			
			// 세션에 id, loginId, userName 저장
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	//아이디 중복찾기
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicated(@RequestParam("loginId") String loginId){
		Map<String, Object> result = new HashMap<>();
		int user = userBO.getExistedUser(loginId);
		
		if(user > 0) {
			result.put("result", "true");
		} else {
			result.put("result", "false");
		}
		
		return result;
	}
	
	
	//회원가입
		@RequestMapping("/sign_up_for_submit")
		public Map<String, Object> signUp(
				@RequestParam("loginId") String loginId, 
				@RequestParam("password") String password, 
				@RequestParam("name") String name, 
				@RequestParam("email") String email){
		
				Map<String, Object> result = new HashMap<>();
				
				// password 암호화해서 저장
				String encrpytedPassword = EncryptUtils.md5(password);
				
				int row = userBO.addUser(loginId, encrpytedPassword, name, email);
				
				if(row > 0) {
					result.put("result", "success");
				} else {
					result.put("result", "fail");
				}
				
			return result;
		}
}
