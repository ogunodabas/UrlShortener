package com.example.UrlShortener.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
@Component
public class ModelUserLogin {

	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ModelUserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public ModelUserLogin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ModelUserLogin [userName=" + userName + ", password=" + password + "]";
	}
	
}
