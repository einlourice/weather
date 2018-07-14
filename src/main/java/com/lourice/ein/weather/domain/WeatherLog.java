package com.lourice.ein.weather.domain;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class WeatherLog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String responseId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String actualWeather;

    @Column(nullable = false)
    private Double temperature;

    @Column(nullable = false)
    private LocalDateTime dTimeInserted;

    @PrePersist
    public void prePersist(){
        if(this.responseId == null){
            this.responseId = UUID.randomUUID().toString();
        }
    }

    public String getResponseId() {
        return responseId;
    }

    public WeatherLog setResponseId(String responseId) {
        this.responseId = responseId;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public WeatherLog setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getActualWeather() {
        return actualWeather;
    }

    public WeatherLog setActualWeather(String actualWeather) {
        this.actualWeather = actualWeather;
        return this;
    }

    public Double getTemperature() {
        return temperature;
    }

    public WeatherLog setTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public LocalDateTime getdTimeInserted() {
        return dTimeInserted;
    }

    public WeatherLog setdTimeInserted(LocalDateTime dTimeInserted) {
        this.dTimeInserted = dTimeInserted;
        return this;
    }

    @Override
    public String toString(){
        return MoreObjects
                .toStringHelper(this)
                .add("id", id)
                .add("responseId", responseId)
                .add("location", location)
                .add("weather", actualWeather)
                .add("temperature", temperature)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!WeatherLog.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final WeatherLog other = (WeatherLog) obj;
        if ((this.temperature == null) ? (other.temperature != null) : !this.temperature.equals(other.temperature)) {
            return false;
        }
        if ((this.actualWeather == null) ? (other.actualWeather != null) : !this.actualWeather.equals(other.actualWeather)) {
            return false;
        }
        return true;
    }
}
