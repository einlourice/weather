package com.lourice.ein.weather.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class DateUtil {

    public static LocalDateTime timeStampToLocalDateTime(long timeStamp){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp),
                        TimeZone.getDefault().toZoneId());
    }

    public static LocalDateTime unixTimeStampToLocalDateTime(long timeStamp){
        return timeStampToLocalDateTime(timeStamp * 1000);
    }
}
