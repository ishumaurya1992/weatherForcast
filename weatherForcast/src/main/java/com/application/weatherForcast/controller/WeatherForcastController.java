package com.application.weatherForcast.controller;


import com.application.weatherForcast.model.WeatherForcast;
import com.application.weatherForcast.service.WeatherService;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/weather")
public class WeatherForcastController {
    @Autowired
    WeatherService weatherService;



    @GetMapping(value = "/current")
    public WeatherForcast getCurrentWeather(@RequestParam(value = "location", defaultValue = "DELHI") String location,
                                            @RequestParam(value = "countryCode", defaultValue = "IN") String countryCode
    ) throws ExecutionException, InterruptedException {

        return weatherService.findCurrentWeather(location.toUpperCase(), countryCode.toUpperCase());

    }

    @GetMapping(value = "/future")
    public WeatherForcast getWeather5DayFutureForcast(@RequestParam(value = "location", defaultValue = "DELHI") String location,
                                                @RequestParam(value = "countryCode", defaultValue = "IN") String countryCode) throws ExecutionException, InterruptedException {

        return weatherService.findWeather5DayFutureForcast(location.toUpperCase(), countryCode.toUpperCase());

    }



}
