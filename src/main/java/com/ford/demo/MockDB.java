package com.ford.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

@Configuration
public class MockDB {
	
	@Autowired
	@Qualifier("jdbcDb1")
	private JdbcTemplate jdbcDb1;
	
	@Autowired
	@Qualifier("jdbcDb2")
	private JdbcTemplate jdbcDb2;
	
	@PostConstruct
	public void initDb1() {
		System.out.println("PostConstruct initDb1...");
		jdbcDb1.execute("create table boleto ( id int not null )");
		insertBoleto(jdbcDb1, 1);
		insertBoleto(jdbcDb1, 2);
		insertBoleto(jdbcDb1, 3);
		insertBoleto(jdbcDb1, 4);
		insertBoleto(jdbcDb1, 5);
	}
	
	@PostConstruct
	public void initDb2() {
		System.out.println("PostConstruct initDb2...");
		jdbcDb2.execute("create table boleto_processado ( id int not null )");
	}
	
	public void insertBoleto(JdbcTemplate jdbcTemplate, Integer id) {
		
		jdbcTemplate.execute("insert into boleto (id) values (?)", new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				return ps.execute();
			}
		});
	}

}
