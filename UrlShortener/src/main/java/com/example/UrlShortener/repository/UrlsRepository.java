package com.example.UrlShortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.UrlShortener.model.Urls;


public interface UrlsRepository extends JpaRepository<Urls, Long>{
	 @Query(value = "SELECT EXISTS (SELECT id FROM urls WHERE user_id=?1 AND url=?2) AS bool",nativeQuery = true)
	 public String isCreatedUrl(Long id,String url);
	 @Query(value = "SELECT EXISTS (SELECT id FROM urls WHERE user_id=?1 AND short_url=?2) AS bool",nativeQuery = true)
	 public String isCreatedShort_url(Long id,String short_url);
	 @Query(value = "SELECT * FROM urls WHERE user_id=?1 ",nativeQuery = true)
	 public List<Urls> allUrlsId(Long user_id);
	 @Query(value ="DELETE FROM urls WHERE urls.user_id=?1 AND urls.short_url=?2 ",nativeQuery = true)
	 public void deleteIdUrl(Long id,String short_url);// error method
	 

}
