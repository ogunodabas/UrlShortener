package com.example.UrlShortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.UrlShortener.controller.AppController;

public class AppControllerTests {

	@Test
	void viewHomePage()
	{
		AppController appController=new AppController();
		String response=appController.viewHomePage();
		assertEquals("index", response);
	}
	@Test
	void viewLoginPage()
	{
		AppController appController=new AppController();
		String response=appController.viewLoginPage();
		assertEquals("login", response);
	}
	
}
