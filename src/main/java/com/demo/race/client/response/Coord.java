package com.demo.race.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class Coord {

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("lat")
    private double lat;
}
