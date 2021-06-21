package com.example.UrlShortener;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlShortenerApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void AppControllerTest() {
		AppControllerTests appControllerTest=new AppControllerTests();
		appControllerTest.viewHomePage();
		appControllerTest.viewLoginPage();
	}
	@Test
	void UserAppControllerTests() {
		UserAppControllerTests userAppControllerTests=new UserAppControllerTests();
		userAppControllerTests.viewUserHomePage();
		
	}

}
