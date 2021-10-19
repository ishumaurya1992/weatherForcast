package com.application.weatherForcast.service.weatherImpl;

import com.application.weatherForcast.service.WeatherAPI;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherAPIImpl implements WeatherAPI {


    OpenWeatherMapClient openWeatherClient  = new OpenWeatherMapClient("f2992aa0321520a333ea924795d4c28d");;

    @Override
    public Weather getCurrentWeather(String location) {

        Weather weather = openWeatherClient
                .currentWeather()
                .single()
                .byCityName(location)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();

        return weather;

    }

    @Override
    public Forecast getWeather5DayFutureForcast(String location) {

         return openWeatherClient
                .forecast5Day3HourStep()
                .byCityName(location)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .count(15)
                .retrieve()
                .asJava();
    }

    @Override
    public Forecast getWeather5DayPastForcast(String location) {
        return null;
    }
}
