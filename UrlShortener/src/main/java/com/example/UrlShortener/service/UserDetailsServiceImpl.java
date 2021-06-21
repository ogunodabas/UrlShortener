package com.example.UrlShortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.UrlShortener.model.User;
import com.example.UrlShortener.model.UserDetailsImpl;
import com.example.UrlShortener.repository.UsersRepository;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private UsersRepository usersRepository;

	public UsersRepository getUsersRepository() {
		return usersRepository;
	}
	@Autowired
	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println("*********username:"+username);
		User user = usersRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		System.out.println("******** tostringsS" + user.toString());

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

	//	return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
		return new UserDetailsImpl(user);
	}
	
	public User getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();	
		return userDetailsImpl.getUser();
	}
}