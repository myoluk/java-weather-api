package com.myoluk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "weather", url = "https://api.open-meteo.com/v1/")
public interface WeatherClient {

    @GetMapping("/forecast?latitude={latitude}&longitude={longitude}" +
            "&daily=weather_code,temperature_2m_max,temperature_2m_min" +
            "&timezone=Europe%2FMoscow&forecast_days={days}")
    String getWeatherForecast(@PathVariable(value = "latitude") double latitude,
                              @PathVariable(value = "longitude") double longitude,
                              @PathVariable(value = "days") int days);

}
