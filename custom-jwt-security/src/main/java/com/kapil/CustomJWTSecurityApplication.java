package com.kapil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomJWTSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomJWTSecurityApplication.class, args);
	}

}
