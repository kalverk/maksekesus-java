package com.integrations.maksekeskus.rest.model;

public abstract class AbstractResponse {
    public enum Status {
        SUCCESS, FAILURE
    }

    private final Status status;

    protected AbstractResponse(Status status) {
        this.status = status;
    }

    private final Status getStatus() {
        return this.status;
    }
}
