package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class TransactionUrl {

    @SerializedName(value = "url")
    private String url;

    @SerializedName(value = "method")
    private String method;

    public TransactionUrl() {
    }

    public TransactionUrl(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
