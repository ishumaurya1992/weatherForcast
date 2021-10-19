package com.application.weatherForcast.consumer;


import com.application.weatherForcast.model.WeatherForcast;
import com.application.weatherForcast.repository.WeatherRepository;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WeatherForcastListner {

    @Autowired
    WeatherRepository weatherRepository;

    @KafkaListener(topics = "${kafka.reuest.topic}", groupId = "${kafka.group.id}")
    @SendTo
    public WeatherForcast handle(WeatherForcast weather) {
        WeatherForcast wf = null;
        try{
          wf =   weatherRepository.save(new WeatherForcast(LocalDate.now().toString(),
                    weather.getCountryCode(), weather.getLocation(), weather.getWeather().toString(), weather.getDuration()));
        }
     catch (DuplicateKeyException exception){

     }

        return wf;
    }
}