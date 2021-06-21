package com.example.UrlShortener.utils;

public class DbConectionProps {

	private String url;
	private String user;
	private String password;
	private String driver;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url, String hostName, String database, String port) {
		this.url = url + "://" + hostName + ":" + port + "/" + database+"?createDatabaseIfNotExist=true&useSSL=false";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public DbConectionProps(String url, String hostName, String database, String user, String password, String port,
			String driver) {
		super();
		this.url = url + "://" + hostName + ":" + port + "/" + database+"?createDatabaseIfNotExist=true&useSSL=false";
		this.user = user;
		this.password = password;
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "DbConectionProps [url=" + url + ", user=" + user + ", password=" + password + ", driver=" + driver
				+ "]";
	}

}
