package com.example.UrlShortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.UrlShortener.utils.URLShortener;

@Configuration
@ComponentScan(basePackages = "com.example.UrlShortener")
@Import({
	DbConfig.class,
	SecurityLoginConfig.class
	
})
public class AppConfig {

	@Bean
	public URLShortener uRLShortener()
	{
		return new URLShortener(8);
	}
}