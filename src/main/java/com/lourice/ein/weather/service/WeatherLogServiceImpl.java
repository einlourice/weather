package com.lourice.ein.weather.service;

import com.google.common.collect.Lists;
import com.lourice.ein.weather.domain.WeatherLog;
import com.lourice.ein.weather.repository.WeatherLogRepository;
import com.lourice.ein.weather.response.openweather.Main;
import com.lourice.ein.weather.response.openweather.Weather;
import com.lourice.ein.weather.response.openweather.WeatherApiResponse;
import com.lourice.ein.weather.response.openweather.WeatherData;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

import static com.lourice.ein.weather.util.DateUtil.unixTimeStampToLocalDateTime;

@Service
public class WeatherLogServiceImpl implements WeatherLogService {

    private final static int MAX_RECORD_RESTRICTION = 5;

    private WeatherLogRepository weatherLogRepository;

    WeatherLogServiceImpl(WeatherLogRepository weatherLogRepository){
        this.weatherLogRepository = weatherLogRepository;
    }

    @Transactional
    public void insertAllUnique(WeatherApiResponse weatherApiResponse){
        List<WeatherLog> weatherLogList = fetchAllRecords();
        if(weatherLogList.size() <= MAX_RECORD_RESTRICTION){
            for(WeatherData weatherData: weatherApiResponse.getWeatherDataList()){
                WeatherLog weatherLog = createWeatherLog(weatherData);
                insertIfUnique(weatherLog, weatherLogList);
            }
        }
    }

    private WeatherLog createWeatherLog(WeatherData weatherData){
        Main main = weatherData.getMain();
        List<Weather> weatherList = weatherData.getWeatherList();

        WeatherLog weatherLog = new WeatherLog();
        weatherLog.setLocation(weatherData.getLocation())
                .setTemperature(main.getTemp())
                .setdTimeInserted( unixTimeStampToLocalDateTime(weatherData.getTimeOfCalculation()) )
                .setActualWeather(CollectionUtils.isEmpty(weatherList) ? "" : weatherList.get(0).getMain());

        return weatherLog;
    }


    @Transactional
    public void insertIfUnique(WeatherLog weatherLog, List<WeatherLog> weatherLogList){
        if(!weatherLogList.contains(weatherLog)){
            this.weatherLogRepository.save(weatherLog);
        }
    }

    @Transactional
    List<WeatherLog> fetchAllRecords(){
        return Lists.newArrayList(this.weatherLogRepository.findAll());
    }
}
