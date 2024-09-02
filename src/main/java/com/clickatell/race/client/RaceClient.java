package com.clickatell.race.client;

import com.clickatell.race.client.config.WeatherApiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Service
public class RaceClient {

    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;

    public RaceClient(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
    }

    public String getWeatherForecast(String location) {
        return restTemplate.getForObject(weatherApiConfig.getBaseUrl(), String.class, location, weatherApiConfig.getApiKey());
    }
}
