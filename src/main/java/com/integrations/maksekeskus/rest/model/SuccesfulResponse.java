package com.integrations.maksekeskus.rest.model;

public class SuccesfulResponse<T> extends AbstractResponse {
    private T result;

    public SuccesfulResponse(T result) {
        super(AbstractResponse.Status.SUCCESS);
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
