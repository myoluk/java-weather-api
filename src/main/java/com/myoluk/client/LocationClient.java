package com.myoluk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "location", url = "https://geocoding-api.open-meteo.com/v1/")
public interface LocationClient {
    @GetMapping("/search?name={cityName}&count=1&language=tr&format=json")
    String getLocationByCityName(@PathVariable String cityName);
}
