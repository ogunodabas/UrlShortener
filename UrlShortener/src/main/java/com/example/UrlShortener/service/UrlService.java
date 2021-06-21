package com.example.UrlShortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UrlShortener.model.Urls;
import com.example.UrlShortener.repository.UrlsRepository;
@Service
public class UrlService {

	
	private UrlsRepository urlsRepository;
	@Autowired
	public void setUrlsRepository(UrlsRepository urlsRepository) {
		this.urlsRepository = urlsRepository;
	}
	
	public boolean isCreatedUrl(Long user_id,String url) {
		String isCreated=urlsRepository.isCreatedUrl(user_id, url);
		if (isCreated.equals("0")) 
			return true;		
		return false;
	}
	public 	List<Urls> getUrls(Long user_id) {
		List<Urls> urlsList = urlsRepository.allUrlsId(user_id);
		return urlsList;
	}
	public Urls save(Urls urls) {
		return urlsRepository.save(urls);
	}
	public void delete(Long id) {
		// urlsRepository.deleteIdUrl(userDetailsImpl.getId(), short_url);
		urlsRepository.deleteById(id);
	}
}
