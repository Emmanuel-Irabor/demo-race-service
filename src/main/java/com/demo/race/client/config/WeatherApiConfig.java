package com.demo.race.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
@ConfigurationProperties(prefix = "race.client.weather")
@Configuration
public class WeatherApiConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private String baseUrl;

    private String apiKey;
}