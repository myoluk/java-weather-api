package com.myoluk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JavaWeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaWeatherApiApplication.class, args);
	}

}
