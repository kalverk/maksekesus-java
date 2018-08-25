package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Return {

    @SerializedName(value = "method")
    private String method;

    @SerializedName(value = "url")
    private String url;

    public Return() {
    }

    public Return(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
