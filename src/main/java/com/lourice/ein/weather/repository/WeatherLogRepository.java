package com.lourice.ein.weather.repository;

import com.lourice.ein.weather.domain.WeatherLog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WeatherLogRepository extends PagingAndSortingRepository<WeatherLog, Long> {
}
