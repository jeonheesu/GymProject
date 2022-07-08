package co.kr.gym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.kr.gym.service.MemberService;

@SpringBootTest
class GymProjectApplicationTests {
	
	@Autowired
	MemberService service;

	//@Test
	void contextLoads() {
		service.memberRead("전희수");
	}
	
	

	
	
	

}
