package com.example.UrlShortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.UrlShortener.controller.UserAppController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserAppController.class)
public class AppControllerTestsMocko {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void viewUserHomePageTest() throws Exception {
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/home");
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		assertEquals("home", result.getResponse().getContentAsString());
	}
}
