package com.lourice.ein.weather.service;

import com.lourice.ein.weather.config.WeatherProperties;
import com.lourice.ein.weather.response.json.WeatherApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapRestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapRestService.class);

    private RestTemplate restTemplate;
    private WeatherLogService weatherLogService;
    private final String BASE_URL;

    OpenWeatherMapRestService(RestTemplate restTemplate,
                              WeatherLogServiceImpl weatherLogService,
                              WeatherProperties weatherProperties){
        this.weatherLogService = weatherLogService;
        this.BASE_URL = weatherProperties.getProviderUrl();
        this.restTemplate = restTemplate;
    }

    public WeatherApiResponse listSpecificCountries() {
        ResponseEntity<WeatherApiResponse> responseEntity = restTemplate.getForEntity(getServiceUrl(), WeatherApiResponse.class);
        WeatherApiResponse weatherApiResponse = null;

        if(HttpStatus.OK == responseEntity.getStatusCode()){
            LOGGER.info("Service provider responds {}", responseEntity);
            weatherApiResponse = responseEntity.getBody();
            this.weatherLogService.insertAllUnique(responseEntity.getBody());
        }else{
            LOGGER.warn("Service provider responds with unhandled http status {}", responseEntity);
        }
        return weatherApiResponse;
    }

    private String getServiceUrl(){
        return this.BASE_URL + "&id=2643743,3067696,5391959";
    }
}
