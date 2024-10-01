package com.demo.race.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Emmanuel-Irabor
 * @since 02/09/2024
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralException extends RuntimeException{
    public GeneralException(String message) {
        super(message);
    }
}
