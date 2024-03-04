package com.myoluk.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myoluk.dto.WeatherDto;
import com.myoluk.entity.Weather;

public class WeatherMapper {

    public static WeatherDto convertToWeatherDto(Weather weather) {
        return new WeatherDto(weather.getDate(),
                weather.getMinTemp(),
                weather.getMaxTemp());
    }

    public static JsonNode convertStringToDailyWeatherJson(String weatherJsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(weatherJsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return rootNode.get("daily");
    }

}
