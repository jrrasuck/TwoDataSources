package com.ford.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoletoRepositorio {
	
	@Autowired
	@Qualifier("jdbcDb1")
	private JdbcTemplate jdbcDb1;

	public List<Boleto> pending() {
		
		List<Boleto> boletos = jdbcDb1.query("select * from boleto"
				, (Object[]) null, new BoletoRowMapper());
		return boletos;
	}

}
