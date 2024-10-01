package com.demo.race.api.response;

import com.demo.race.common.RaceInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data

public class RaceResponse {

    private List<RaceInfo> race;
}