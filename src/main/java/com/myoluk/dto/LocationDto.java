package com.myoluk.dto;

public record LocationDto(String name,
                          String country,
                          String countryCode,
                          String timezone,
                          double latitude,
                          double longitude) {
}
