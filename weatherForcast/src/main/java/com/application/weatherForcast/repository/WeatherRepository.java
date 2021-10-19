package com.application.weatherForcast.repository;

import com.application.weatherForcast.model.WeatherForcast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends MongoRepository<WeatherForcast, String> {

    WeatherForcast findByDate(String date);

    WeatherForcast findByDateAndCountryCodeAndLocationIgnoreCase(String string, String location, String countrtyCode);

    WeatherForcast findByDateAndCountryCodeAndLocationAndDuration(String time, String countryCode, String location,String duration);
}
