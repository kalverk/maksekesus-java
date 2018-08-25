package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class BankLink {

    @SerializedName(value = "country")
    private String country;

    @SerializedName(value = "logo_url")
    private String logoUrl;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "url")
    private String url;

    public BankLink() {
    }

    public BankLink(String country, String logoUrl, String name, String url) {
        this.country = country;
        this.logoUrl = logoUrl;
        this.name = name;
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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
