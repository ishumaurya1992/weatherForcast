package com.application.weatherForcast.service.weatherImpl;



import com.application.weatherForcast.model.WeatherForcast;
import com.application.weatherForcast.repository.WeatherRepository;
import com.application.weatherForcast.service.WeatherAPI;
import com.application.weatherForcast.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.weather.Weather;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;


@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    WeatherAPI weatherAPI;

    @Value("${kafka.reuest.topic}")
    private String requestTopic;

    @Autowired
    public ReplyingKafkaTemplate<String, WeatherForcast, WeatherForcast> replyingKafkaTemplate;



    @Override
    public WeatherForcast findCurrentWeather(String location, String countryCode) throws ExecutionException {
        WeatherForcast weather =  weatherRepository.findByDateAndCountryCodeAndLocationAndDuration(LocalDate.now().toString(), countryCode, location ,"1");
        if (weather == null) {
            Weather currentWeather = weatherAPI.getCurrentWeather(location);
            WeatherForcast wf = getData(currentWeather);

            return producerConsumer( wf);

        }

        return weather;
    }

    @Override
    public WeatherForcast findWeather5DayFutureForcast(String location, String countryCode) {
        String duration = "2";
        WeatherForcast weather =  weatherRepository.findByDateAndCountryCodeAndLocationAndDuration
                (LocalDate.now().toString(), countryCode, location, duration);
        if (weather == null) {

            Forecast forecast = weatherAPI.getWeather5DayFutureForcast(location);
            WeatherForcast weatherForcast = getData(forecast);

            weatherForcast = producerConsumer( weatherForcast);

            return weatherForcast;
        }else{

            return weather;
        }



    }

    private WeatherForcast getData(Object object){

        if(object instanceof Weather){
            Weather weather = (Weather)object;
          return   new WeatherForcast(LocalDate.now().toString(),
                    weather.getLocation().getCountryCode().toUpperCase(), weather.getLocation().getName().toUpperCase(),jsonString(weather),"1");

        }else {
            Forecast weather = (Forecast)object;
            return new WeatherForcast(LocalDate.now().toString(),
                    weather.getLocation().getCountryCode().toUpperCase(), weather.getLocation().getName().toUpperCase(),jsonString(weather),"2");
        }

    }

   private WeatherForcast producerConsumer(WeatherForcast weatherForcast){
        ProducerRecord<String, WeatherForcast> record = new ProducerRecord<>(requestTopic, null, "STD001", weatherForcast);
        RequestReplyFuture<String, WeatherForcast, WeatherForcast> future = replyingKafkaTemplate.sendAndReceive(record);
        ConsumerRecord<String, WeatherForcast> data = null;
        try {
            data = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return data.value();
    }


  private   String jsonString(Object obj){
        ObjectMapper mapper  =new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonStr = null;
        try {
            jsonStr =  mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}



