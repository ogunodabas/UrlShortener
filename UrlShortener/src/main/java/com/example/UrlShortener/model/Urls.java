package com.example.UrlShortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="urls")
public class Urls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false )
	private Long  id;
	@Column(name = "user_id", nullable = false )
	private Long user_id;
	@Column(name = "url" , nullable = false , columnDefinition = "VARCHAR(255) default 'null'" )
	private String url;
	@Column(name = "short_url" , nullable = false , length = 8,unique = true)
	private String short_url;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

	public Urls(Long id, Long user_id, String url, String short_url) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.url = url;
		this.short_url = short_url;
	}
	public Urls(Long user_id, String url, String short_url) {
		super();
		this.user_id = user_id;
		this.url = url;
		this.short_url = short_url;
	}
	public Urls() {
	}
	@Override
	public String toString() {
		return "Urls [id=" + id + ", user_id=" + user_id + ", url=" + url + ", short_url=" + short_url + "]";
	}

	
}
