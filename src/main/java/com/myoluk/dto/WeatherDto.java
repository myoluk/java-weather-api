package com.myoluk.dto;

import java.time.LocalDate;

public record WeatherDto(LocalDate date,
                         double minTemp,
                         double maxTemp) {
}
