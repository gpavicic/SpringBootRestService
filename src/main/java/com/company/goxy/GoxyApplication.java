package com.company.goxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.company.goxy")
public class GoxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoxyApplication.class, args);
	}
}
