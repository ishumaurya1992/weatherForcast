package com.weather.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WeatherSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSecurityApplication.class, args);
	}


}

