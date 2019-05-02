package com.ford.demo;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration: factory de bean
@Configuration
public class DBConfig {
	
	//@Bean: anotação exclusiva de método onde é produzido um bean
	@Bean
	@ConfigurationProperties(prefix="db2.datasource")
	public DataSource db2() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource db1() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public JdbcTemplate jdbcDb1() {
		return new JdbcTemplate(db1());
	}
	
	@Bean
	public JdbcTemplate jdbcDb2() {
		return new JdbcTemplate(db2());
	}

}
