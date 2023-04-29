package com.api.company_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CompanyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagerApplication.class, args);
		System.out.println("Senha: " + new BCryptPasswordEncoder().encode("12345"));
	}

}
