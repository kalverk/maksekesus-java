package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Notifications {

    @SerializedName(value = "email")
    private String email;

    @SerializedName(value = "method")
    private String method;

    @SerializedName(value = "url")
    private String url;

    public Notifications() {
    }

    public Notifications(String email, String method, String url) {
        this.email = email;
        this.method = method;
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
