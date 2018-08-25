package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class OtherPaymentMethodValues {

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "url")
    private String url;

    public OtherPaymentMethodValues() {
    }

    public OtherPaymentMethodValues(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
