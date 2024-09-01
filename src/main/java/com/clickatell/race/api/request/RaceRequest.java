package com.clickatell.race.api.request;

import com.clickatell.race.common.RaceType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
public class RaceRequest {

    private String name;

    private String location;

    private RaceType type;

    private LocalDateTime startTime;

    private List<Riders> riders;


    @Data
    public static class Riders {

        private String name;
    }
}
