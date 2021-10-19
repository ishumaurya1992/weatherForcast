package com.application.weatherForcast.model;


import com.application.weatherForcast.model.weatherModel.AtmosphericPressure;
import com.application.weatherForcast.model.weatherModel.Clouds;
import com.application.weatherForcast.model.weatherModel.Temperature;
import com.application.weatherForcast.model.weatherModel.onecall.Rain;
import com.application.weatherForcast.model.weatherModel.onecall.Snow;
import com.application.weatherForcast.model.weatherModel.onecall.Wind;
import com.application.weatherForcast.model.weatherModel.weather.Location;

import java.time.LocalDateTime;

public class CustomWeather {

    private LocalDateTime calculationTime;

    private Temperature temperature;

    private AtmosphericPressure atmosphericPressure;


    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Clouds clouds;
    private Location location;
    public CustomWeather() {
    }

    public LocalDateTime getCalculationTime() {
        return calculationTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public AtmosphericPressure getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(AtmosphericPressure atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public void setCalculationTime(LocalDateTime calculationTime) {
        this.calculationTime = calculationTime;
    }



    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
