package com.demo.race.api.response;

import com.demo.race.common.RiderInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
public class FastestRidersResponse {

    List<FastestRidersInfo> riders;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class FastestRidersInfo extends RiderInfo {

        private Long position;

        private BigDecimal finishTime;
    }
}
