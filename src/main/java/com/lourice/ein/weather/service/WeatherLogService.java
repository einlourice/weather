package com.lourice.ein.weather.service;

import com.lourice.ein.weather.domain.WeatherLog;
import com.lourice.ein.weather.response.json.WeatherApiResponse;

import java.util.List;

public interface WeatherLogService {
    void insertAllUnique(WeatherApiResponse weatherApiResponse);

    void insertIfUnique(WeatherLog weatherLog, List<WeatherLog> weatherLogList);
}
