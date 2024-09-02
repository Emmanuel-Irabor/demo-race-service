package com.clickatell.race.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class Wind {

    @JsonProperty("speed")
    private double speed;

    @JsonProperty("deg")
    private int deg;
}
