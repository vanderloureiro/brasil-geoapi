package com.br.brasilgeoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BrasilGeoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilGeoapiApplication.class, args);
	}

}
