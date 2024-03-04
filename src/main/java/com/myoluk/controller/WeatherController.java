package com.myoluk.controller;

import com.myoluk.dto.WeatherDto;
import com.myoluk.enums.EnumDays;
import com.myoluk.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather/")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{cityName}/{days}")
    public List<WeatherDto> getWeatherByLocation(@PathVariable(value = "cityName") String cityName,
                                                 @PathVariable(value = "days") EnumDays enumDays) {
        return weatherService.getWeatherForecastByCity(cityName, enumDays);
    }

}
