package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class LinkUrl {

    @SerializedName(value = "href")
    private String href;

    public LinkUrl() {
    }

    public LinkUrl(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
