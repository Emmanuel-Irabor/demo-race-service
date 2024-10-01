package com.demo.race.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Emmanuel-Irabor
 * @since 03/09/2024
 */
@Data
public class RiderRequest {

    @NotBlank(message = "riderName cannot be blank")
    private String riderName;
}
