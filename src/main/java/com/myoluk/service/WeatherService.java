package com.myoluk.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.myoluk.client.LocationClient;
import com.myoluk.client.WeatherClient;
import com.myoluk.dto.LocationDto;
import com.myoluk.dto.WeatherDto;
import com.myoluk.entity.Location;
import com.myoluk.entity.Weather;
import com.myoluk.enums.EnumDays;
import com.myoluk.exception.WeatherException;
import com.myoluk.mapper.LocationMapper;
import com.myoluk.mapper.WeatherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    private final LocationClient locationClient;

    public List<WeatherDto> getWeatherForecastByCity(String cityName, EnumDays enumDays) {

        List<WeatherDto> weathers = new ArrayList<>();
        int days = enumDays.getValue();

        LocationDto location = getLocationByCityName(cityName);

        String response;
        try {
            response = weatherClient.getWeatherForecast(
                    location.latitude(),
                    location.longitude(),
                    days);
        } catch (Exception e) {
            throw new WeatherException("Bad request!");
        }

        JsonNode dailyForecasts = WeatherMapper.convertStringToDailyWeatherJson(response);

        for (int i=0; i<days; i++) {
            Weather weather = new Weather(
                    LocalDate.parse(dailyForecasts.get("time").get(i).asText()),
                    dailyForecasts.get("temperature_2m_min").get(i).asDouble(),
                    dailyForecasts.get("temperature_2m_max").get(i).asDouble()
            );
            weathers.add(WeatherMapper.convertToWeatherDto(weather));
        }

        return weathers;
    }

    private LocationDto getLocationByCityName(String cityName) {
        String response = locationClient.getLocationByCityName(cityName);
        Location location = LocationMapper.convertJsonToLocation(response);
        return LocationMapper.convertToLocationDto(location);
    }

}
