package com.lourice.ein.weather.response.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty("weather")
    private List<Weather> weatherList = new ArrayList<>();

    @JsonProperty
    private Main main;

    @JsonProperty("name")
    private String location;

    @JsonProperty("dt")
    private long timeOfCalculation;

    public long getTimeOfCalculation() {
        return timeOfCalculation;
    }

    public void setTimeOfCalculation(long timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return this.location;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
