package com.ford.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BoletoJob {
	
	@Autowired
	private ProcessaBoletoService service;
	
	@Scheduled(cron="0 * * * * *")
	public void doTask() {
		service.processaBoleto();
	}
}
