package com.demo.race.service.param;

import com.demo.race.common.RaceType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
public class RaceParam {

    private String name;

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private RaceType type;

    private LocalDateTime startTime;
}
