package com.integrations.maksekeskus.exceptions;

import com.integrations.maksekeskus.rest.model.ErrorResponse;

public class ApiException extends Exception {
    private final ErrorResponse errorResponse;

    public ApiException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
