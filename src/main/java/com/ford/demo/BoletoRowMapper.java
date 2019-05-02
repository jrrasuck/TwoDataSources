package com.ford.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoletoRowMapper implements RowMapper<Boleto> {

	@Override
	public Boleto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Boleto boleto = new Boleto();
		boleto.setId(rs.getInt("id"));
		return boleto;
	}

}
