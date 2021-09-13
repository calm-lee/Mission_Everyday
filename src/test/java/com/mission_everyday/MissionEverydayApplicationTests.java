package com.mission_everyday;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mission_everyday.user.BO.UserBO;

// 단위 test (Unit test)
@SpringBootTest
class MissionEverydayApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserBO userBO;

	
	  @Test 
	  void contextLoads() { 
		  
		  logger.debug("#######출력######");
	  
		  int user = userBO.getExistedUser("mongmo"); 
		  
		  logger.debug("#########user:" + user);
	  
		  assertNotNull(user); // Junit에서 제공해주는 메소드 (null인지 아닌지 파악)
	  
	  }
	 

	//@Test
	void 더하기테스트() {
		logger.debug(("$$$$ 더하기 테스트 시작"));

		int a = 2;
		int b = 3;

		assertEquals(5, sum(a, b)); // Junit에서 제공해주는 메소드 (같은지 아닌지 파악)
	}

	int sum(int x, int y) {
		return x + y;
	}

	// @Transactional // rollback
}
