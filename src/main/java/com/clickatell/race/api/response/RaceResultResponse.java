package com.clickatell.race.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RaceResultResponse extends RaceResponse {

    private Long id;

    private BigDecimal finishTime;

    private boolean finished;
}
