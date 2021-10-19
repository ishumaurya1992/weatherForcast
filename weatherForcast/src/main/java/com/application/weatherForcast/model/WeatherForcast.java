package com.application.weatherForcast.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weatherForcast")
public class WeatherForcast {

    @Id
    private String id;

    private String date;

    private String countryCode;

    private String location;

    private String weather;

    private String duration;

    public WeatherForcast(String date, String countryCode, String location, String weather , String duration) {
        this.date = date;
        this.countryCode = countryCode;
        this.location = location;
        this.weather = weather;
        this.duration = duration;
    }

    public WeatherForcast() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
