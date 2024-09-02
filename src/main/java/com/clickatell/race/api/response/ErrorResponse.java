package com.clickatell.race.api.response;

import lombok.Data;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@Data
public class ErrorResponse {

    private int status;

    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
