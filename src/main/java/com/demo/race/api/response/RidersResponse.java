package com.demo.race.api.response;

import com.demo.race.common.RiderInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
public class RidersResponse {

    List<RiderInfo> riders;
}
