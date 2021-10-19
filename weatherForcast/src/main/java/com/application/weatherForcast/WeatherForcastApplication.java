package com.application.weatherForcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class WeatherForcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherForcastApplication.class, args);



    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
