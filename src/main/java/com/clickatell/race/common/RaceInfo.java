package com.clickatell.race.common;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class RaceInfo {

    private Long id;

    private String name;

    private RaceLocationInfo location;

    private RaceType type;

    private LocalDateTime startTime;

    private List<RiderInfo> riders;
}
