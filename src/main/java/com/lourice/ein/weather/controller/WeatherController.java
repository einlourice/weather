package com.lourice.ein.weather.controller;

import com.lourice.ein.weather.response.json.WeatherApiResponse;
import com.lourice.ein.weather.service.OpenWeatherMapRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private OpenWeatherMapRestService openWeatherMapRestService;

    WeatherController(OpenWeatherMapRestService openWeatherMapRestService){
        this.openWeatherMapRestService = openWeatherMapRestService;
    }

    @GetMapping
    @RequestMapping("/")
    public ResponseEntity<WeatherApiResponse> list(){
        WeatherApiResponse response = this.openWeatherMapRestService.listSpecificCountries();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
