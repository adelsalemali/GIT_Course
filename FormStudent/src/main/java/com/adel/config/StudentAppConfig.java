package com.adel.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.adel"})
public class StudentAppConfig {

	@Bean
	public InternalResourceViewResolver viewResource() {

		InternalResourceViewResolver resourceView = new InternalResourceViewResolver();

		resourceView.setPrefix("/WEB-INF/view/");
		resourceView.setSuffix(".jsp");
		return resourceView; 
	} 

	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
		
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		
		//set the db info to dataSource object
		dataSource.setUsername("adel");
		dataSource.setPassword("adel156651");
		dataSource.setUrl("jdbc:mysql://localhost/uni");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
}
