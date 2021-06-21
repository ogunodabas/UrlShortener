package com.example.UrlShortener.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityLoginConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	@Qualifier("userDetailsServiceImpl")
    @Autowired
	public AuthenticationProvider authProvider(UserDetailsService userDetailsService)
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("1"));
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		return provider;
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
		.authorizeRequests().antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/home")
		.and()
		.logout().
		permitAll();
    }
}