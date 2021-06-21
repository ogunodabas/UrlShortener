package com.example.UrlShortener.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.UrlShortener.model.ModelUserLogin;
import com.example.UrlShortener.model.Urls;
import com.example.UrlShortener.model.User;
import com.example.UrlShortener.service.UrlService;
import com.example.UrlShortener.service.UrlShortenerService;
import com.example.UrlShortener.service.UserDetailsServiceImpl;
@Controller
public class UserAppController {
	private UserDetailsServiceImpl userDetailsServiceImpl;
	private UrlService urlService;
	private ModelUserLogin modelUserLogin;
	private UrlShortenerService urlShortenerService;
	
	@Autowired
	public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	@Autowired
	public void setUrlService(UrlService urlService) {
		this.urlService = urlService;
	}
	@Autowired
	public void setModelUserLogin(ModelUserLogin modelUserLogin) {
		this.modelUserLogin = modelUserLogin;
	}
	@Autowired
	public void setUrlShortenerService(UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}

	@GetMapping(value = { "/home" })
	public String viewUserHomePage(Model model) {
		System.out.println("viewUserHomePage");
		User user = userDetailsServiceImpl.getUser();
		model.addAttribute("user", user.toString());
		modelUserLogin = new ModelUserLogin(user.getUsername(), user.getPassword());
		model.addAttribute("user2", modelUserLogin.toString());
		return "home";
	}

	@GetMapping(value = { "/home/delete" })
	@ResponseBody
	public ModelAndView viewUserDeletePage() {
		ModelAndView modelAndView = new ModelAndView("home/delete");
		System.out.println("viewUserDeletePage");
		List<Urls> urlsList = urlService.getUrls(userDetailsServiceImpl.getUser().getId());
		modelAndView.addObject("urlsList", urlsList);
		return modelAndView;
	}

	@GetMapping(value = "/home/delete/{id}")
	public String viewUserDeletePagePost(@PathVariable Long id) {
		System.out.println("viewUserDeleteAction");
		System.out.println("id:::" + id);
		urlService.delete(id);
		return "redirect:/home/delete";
	}

	@GetMapping(value = { "/home/select" })
	public ModelAndView viewUserSelectPage(Model model) {

		System.out.println("viewUserSelectPage");
		ModelAndView modelAndView = new ModelAndView("home/select");
		List<Urls> urlsList = urlService.getUrls(userDetailsServiceImpl.getUser().getId());

		System.out.println("***************::::" + urlsList.toString());
		modelAndView.addObject("urlsList", urlsList);
		return modelAndView;
	}

	@GetMapping(value = { "/home/add" })
	public String viewUserAddPage() {
		System.out.println("viewUserAddPage");
		return "home/add";
	}

	@PostMapping(value = "/home/add")
	public String viewUserAddPagePost(@RequestParam("url") String url, Model model) {
		System.out.println("viewUserAddPagePost");
		final String shortedUrl =  urlShortenerService.shortenUrl(url);
		System.out.println("url"+url);

		System.out.println("shortedUrl"+shortedUrl);
		String err = "";
		boolean isCreated = urlService.isCreatedUrl(userDetailsServiceImpl.getUser().getId(),url);
		if (isCreated) {
			if (null == urlService.save(new Urls(userDetailsServiceImpl.getUser().getId(), url, shortedUrl)))
				err = "not saved";
			else
				err = "saved";
		} else
			err = "exist in the database";

		model.addAttribute("err", err);
		return "/home/add";
	}

}
