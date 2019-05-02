package com.ford.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TwoDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoDataSourcesApplication.class, args);
	}

}
