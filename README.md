Brings daily (1), weekly (7) and monthly (16) weather forecasts by **city name.**

> endpoint `/api/v1/weather/{city}/{days}`

Weather API : [Open-Meteo](https://open-meteo.com)

Geographic Coordinates API : [Open-Meteo](https://open-meteo.com)

_*Weather API needs geographic coordinates._

## Output

**Request URL**
```
http://localhost:8080/api/v1/weather/istanbul/DAILY
```

**Response**
```
[
  {
    "date": "2024-03-04",
    "minTemp": 6.4,
    "maxTemp": 12.5
  }
]
```

