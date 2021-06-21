package com.example.UrlShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.UrlShortener.repository.UrlsRepository;
import com.example.UrlShortener.repository.UsersRepository;

@EnableJpaRepositories(basePackageClasses = {
		UsersRepository.class,
		UrlsRepository.class
		
})
@EnableConfigurationProperties
@SpringBootApplication
public class UrlShortenerApplication implements CommandLineRunner {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@Override
	public void run(String... args) throws Exception {
		// MYSQL VERSİON >5.5.2
		String sqlUtf="ALTER DATABASE temp CHARACTER SET utf8 COLLATE utf8_unicode_ci;";
		// MYSQL VERSİON <=5.5.2
		//String sqlUtf="ALTER DATABASE temp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;";
		jdbcTemplate.update(sqlUtf);
		
		//ROLE=0 --> USER , 1=ADMIN
		//$2a$10$beYqQGOJItoF.97brgB68e1EPBdGtouIgx5TbQxhy9Af3suWU9/j2 --> password=1
		String sql="INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES ('1', '$2a$10$beYqQGOJItoF.97brgB68e1EPBdGtouIgx5TbQxhy9Af3suWU9/j2', '0', '1');";
		String sql2="INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES ('2', '$2a$10$beYqQGOJItoF.97brgB68e1EPBdGtouIgx5TbQxhy9Af3suWU9/j2', '0', '2');";
		String sql3="INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES ('3', '$2a$10$beYqQGOJItoF.97brgB68e1EPBdGtouIgx5TbQxhy9Af3suWU9/j2', '0', '3');";
		
		jdbcTemplate.update(sql);
		jdbcTemplate.update(sql2);
		jdbcTemplate.update(sql3);
		
		
	}

}
