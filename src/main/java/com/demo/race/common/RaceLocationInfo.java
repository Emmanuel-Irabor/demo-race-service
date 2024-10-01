package com.demo.race.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class RaceLocationInfo {

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
