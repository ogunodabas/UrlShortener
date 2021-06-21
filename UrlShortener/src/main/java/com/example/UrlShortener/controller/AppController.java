package com.example.UrlShortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping(value = {"/index","/"})
	public String viewHomePage()
	{
		System.out.println("viewHomePage");
		return "index";
	}
	@GetMapping(value = "/login")
	public String viewLoginPage()
	{
		System.out.println("viewLoginPage");
		return "login";
	}
	
	
}
