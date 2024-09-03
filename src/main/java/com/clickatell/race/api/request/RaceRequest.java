package com.clickatell.race.api.request;

import com.clickatell.race.common.RaceLocationInfo;
import com.clickatell.race.common.RaceRider;
import com.clickatell.race.common.RaceType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
public class RaceRequest {


    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Location cannot be null")
    private RaceLocationInfo location;

    @NotNull(message = "Race type cannot be null")
    private RaceType type;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    @NotNull(message = "Riders list cannot be null")
    @Size(min = 1, message = "At least one riders must be provided")
    private List<RaceRider> riders;
}
