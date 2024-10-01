package com.demo.race.api.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class RaceResultRequest {

    private BigDecimal finishTime;

    private boolean finished;
}
