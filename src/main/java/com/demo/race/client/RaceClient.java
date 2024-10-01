package com.demo.race.client;

import com.demo.race.client.config.WeatherApiConfig;
import com.demo.race.client.response.WeatherForecastResponse;
import com.demo.race.common.Constants;
import com.demo.race.common.exceptions.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Slf4j
@Service
public class RaceClient {

    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;

    public RaceClient(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
    }

    public WeatherForecastResponse getWeatherForecast(BigDecimal latitude, BigDecimal longitude) {
        try {
            return restTemplate.getForObject(weatherApiConfig.getBaseUrl(), WeatherForecastResponse.class,
                    latitude, longitude, weatherApiConfig.getApiKey());
        } catch (Exception e) {
            log.error("An error occurred while trying to get weather information", e);
            throw new GeneralException(Constants.INTERNAL_SERVER_ERROR);
        }
    }

}
