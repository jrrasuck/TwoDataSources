package com.ford.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcessaBoletoService {
	
	@Autowired
	private BoletoRepositorio boletoRepositorio;
	
	@Autowired
	private BoletoProcessadoRepositorio boletoProcessadoRepositorio;
	
	@Transactional
	public void processaBoleto() {
		
		for (Boleto boleto : boletoRepositorio.pending()) {
			processaBoleto(boleto);
		}
	}

	private void processaBoleto(Boleto boleto) {
		boletoProcessadoRepositorio.save(boleto);
	}

}
