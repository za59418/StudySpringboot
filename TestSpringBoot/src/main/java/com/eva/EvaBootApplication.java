package com.eva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
public class EvaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaBootApplication.class, args);
	}

}
