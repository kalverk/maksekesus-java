package com.integrations.maksekeskus.rest.model;

public class ErrorResponse extends AbstractResponse {
    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        super(Status.FAILURE);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
