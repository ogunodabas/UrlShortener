package com.example.UrlShortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UrlShortener.repository.UrlsRepository;
import com.example.UrlShortener.utils.URLShortener;

@Service
public class UrlShortenerService {

	 
	private URLShortener urlShortener;
	private UrlsRepository urlsRepository;
	
	@Autowired
	public void setUrlsRepository(UrlsRepository urlsRepository) {
		this.urlsRepository = urlsRepository;
	}
	@Autowired
	public void setUrlShortener(URLShortener urlShortener) {
		this.urlShortener = urlShortener;
	}

	public boolean isShortedUrlCreated(Long id, String short_url) {
		String isCreated=urlsRepository.isCreatedShort_url(id, short_url);
		if (isCreated.equals("0")) 
			return true;		
		return false;
	}
	public String shortenUrl(String url) {
		return urlShortener.shortenUrl(url);
	}
}
