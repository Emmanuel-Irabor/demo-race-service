package com.clickatell.race.api.response;

import com.clickatell.race.common.RaceLocationInfo;
import com.clickatell.race.common.RaceType;
import com.clickatell.race.common.RiderInfo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data

public class RaceResponse {

    private List<RaceInfo> race;

    @Data
    private static class RaceInfo {

        private Long id;

        private String name;

        private RaceLocationInfo location;

        private RaceType type;

        private LocalDateTime startTime;

        private List<RiderInfo> riders;
    }
}
