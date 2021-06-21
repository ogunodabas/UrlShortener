package com.example.UrlShortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UrlShortener.model.User;
@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

	 public User findByUsername(String userName);

}
