package com.clickatell.race.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class Main {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("temp_max")
    private double tempMax;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("sea_level")
    private int seaLevel;

    @JsonProperty("grnd_level")
    private int grndLevel;
}
