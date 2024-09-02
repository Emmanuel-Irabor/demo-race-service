package com.clickatell.race.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class Clouds {

    @JsonProperty("all")
    private int all;
}
