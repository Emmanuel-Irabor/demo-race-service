package com.clickatell.race.client;

import com.clickatell.race.client.response.WeatherForecastResponse;
import com.clickatell.race.client.config.WeatherApiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

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

    public WeatherForecastResponse getWeatherForecast(BigDecimal latitude, BigDecimal longitude) {
        return restTemplate.getForObject(weatherApiConfig.getBaseUrl(), WeatherForecastResponse.class,
                latitude, longitude, weatherApiConfig.getApiKey());
    }

}
