package com.application.weatherForcast.service;

import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.weather.Weather;

public interface WeatherAPI {

    Weather getCurrentWeather(String location);

    Forecast getWeather5DayFutureForcast(String location);

    Forecast getWeather5DayPastForcast(String location);
}
