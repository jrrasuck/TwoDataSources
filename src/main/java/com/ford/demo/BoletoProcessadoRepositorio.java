package com.ford.demo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

@Repository
public class BoletoProcessadoRepositorio {

	@Autowired
	@Qualifier("jdbcDb2")
	private JdbcTemplate jdbcDb2;

	public void save(Boleto boleto) {

		Boleto found = null;
		try {
			found = jdbcDb2.queryForObject("select * from boleto_processado where id = ?",
					new Object[] { boleto.getId() }, new BoletoRowMapper());
			System.out.println("Boleto já processado: " + found.getId());
		} catch (EmptyResultDataAccessException exception) {
			System.out.println("Boleto não encontrado.. Inserindo");
			insertBoleto(boleto);
		}
		
	}

	private void insertBoleto(Boleto boleto) {

		jdbcDb2.execute("insert into boleto_processado (id) values (?)", new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, boleto.getId());
				return ps.execute();
			}
		});
	}

}
