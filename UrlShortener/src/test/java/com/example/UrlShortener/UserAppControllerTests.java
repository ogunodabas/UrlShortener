package com.example.UrlShortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.UrlShortener.controller.UserAppController;
import com.example.UrlShortener.model.ModelUserLogin;
import com.example.UrlShortener.repository.UsersRepository;
import com.example.UrlShortener.service.UrlService;
import com.example.UrlShortener.service.UrlShortenerService;
import com.example.UrlShortener.service.UserDetailsServiceImpl;

public class UserAppControllerTests {

	@Autowired
	Model model;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private UrlService urlService;
	@Autowired
	private ModelUserLogin modelUserLogin;
	@Autowired 
	private UrlShortenerService urlShortenerService;
	@Autowired
	UsersRepository usersRepository;
	@Test
	
	void viewUserHomePage()
	{
		userDetailsServiceImpl.setUsersRepository(usersRepository);
		UserAppController userAppController=new UserAppController();
		userAppController.setModelUserLogin(modelUserLogin);
		userAppController.setUrlService(urlService);
		userAppController.setUrlShortenerService(urlShortenerService);
		userAppController.setUserDetailsServiceImpl(userDetailsServiceImpl);
		String response=userAppController.viewUserHomePage(model);
		assertEquals("home", response);
	}
}
