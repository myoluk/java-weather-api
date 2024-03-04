package com.myoluk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {
    String name;
    String country;
    String countryCode;
    String timezone;
    double latitude;
    double longitude;
}
