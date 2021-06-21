package com.example.UrlShortener.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.UrlShortener.model.DbConnection;
import com.example.UrlShortener.model.MySqlConnectionImpl;
import com.example.UrlShortener.utils.DbConectionProps;
import com.example.UrlShortener.utils.DbUrlNames;

@Configuration
public class DbConfig {

	@Bean
	public DataSource dataSource() {
		String url = DbUrlNames.getMySqlUrl();
		String hostName = "localhost";
		String database = "temp";
		String user = "root";
		String password = "ogun";
		String port = "3306";
		String driver = "com.mysql.cj.jdbc.Driver";
		DbConectionProps dbConectionProps = new DbConectionProps(url, hostName, database, user, password, port, driver);
		DbConnection dbConnection = new MySqlConnectionImpl();
		return dbConnection.dataSource(dbConectionProps);
	}
}
