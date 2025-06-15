package com.student.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.common.icici.*", "com.student.validation.*"})
@EntityScan(basePackages = {"com.common.icici.*", "com.student.validation.*"})
@EnableJpaRepositories(basePackages = {"com.common.icici.*", "com.student.validation.*"})
public class SpringBootValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootValidationApplication.class, args);
	}

}
