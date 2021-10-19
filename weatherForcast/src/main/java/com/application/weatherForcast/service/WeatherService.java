package com.application.weatherForcast.service;


import com.application.weatherForcast.model.WeatherForcast;

import java.util.concurrent.ExecutionException;


public interface WeatherService {

    WeatherForcast findCurrentWeather(String location, String countryCode) throws ExecutionException;

    WeatherForcast findWeather5DayFutureForcast(String location, String countryCode);
}

