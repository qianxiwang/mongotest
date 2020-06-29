package com.test.mongotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MongotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotestApplication.class, args);
	}

}
