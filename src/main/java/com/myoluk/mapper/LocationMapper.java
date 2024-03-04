package com.myoluk.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myoluk.dto.LocationDto;
import com.myoluk.entity.Location;
import com.myoluk.exception.LocationException;

public class LocationMapper {

    public static LocationDto convertToLocationDto(Location location) {
        return new LocationDto(
                location.getName(),
                location.getCountry(),
                location.getCountryCode(),
                location.getTimezone(),
                location.getLatitude(),
                location.getLongitude()
        );
    }

    public static Location convertJsonToLocation(String locationJsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = objectMapper.readTree(locationJsonString);
        } catch (Exception e) {
            throw new LocationException("Unknown city!");
        }
        JsonNode resultsNode = rootNode.get("results").get(0);

        return new Location(
                resultsNode.get("name").asText(),
                resultsNode.get("country").asText(),
                resultsNode.get("country_code").asText(),
                resultsNode.get("timezone").asText(),
                resultsNode.get("latitude").asDouble(),
                resultsNode.get("longitude").asDouble()
        );
    }
}
