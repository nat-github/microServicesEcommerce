package com.example.contracttesting.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerserviceApplication.class, args);
	}

}
