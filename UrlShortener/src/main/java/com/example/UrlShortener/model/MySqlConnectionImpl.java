package com.example.UrlShortener.model;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

import com.example.UrlShortener.utils.DbConectionProps;

public class MySqlConnectionImpl implements DbConnection {

	@Override
	public DataSource dataSource(final DbConectionProps dbConectionProps) {
		return DataSourceBuilder
				.create()
				.username(dbConectionProps.getUser())
				.password(dbConectionProps.getPassword())
				.url(dbConectionProps.getUrl())
				.driverClassName(dbConectionProps.getDriver())
				.build();
	}

}
