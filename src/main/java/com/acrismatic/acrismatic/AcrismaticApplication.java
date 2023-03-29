package com.acrismatic.acrismatic;

import org.springframework.boot	.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.acrismatic.acrismatic.repository")
public class AcrismaticApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcrismaticApplication.class, args);
	}

}
