package com.clickatell.race.api.response;

import com.clickatell.race.client.response.WeatherForecastResponse;
import com.clickatell.race.entity.Race;
import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class RaceWeatherForecastResponse {

    private Race race;

    private WeatherForecastResponse weatherForecast;
}
