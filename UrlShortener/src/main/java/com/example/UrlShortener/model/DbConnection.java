package com.example.UrlShortener.model;

import javax.sql.DataSource;

import com.example.UrlShortener.utils.DbConectionProps;



public interface DbConnection {

	public DataSource dataSource(final DbConectionProps dbConectionProps);
	
}
