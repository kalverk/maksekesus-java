package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "object")
    private String object;

    @SerializedName(value = "email")
    private String email;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "ip")
    private String ip;

    @SerializedName(value = "ip_country")
    private String ipCountry;

    @SerializedName(value = "country")
    private String country;

    @SerializedName(value = "locale")
    private String locale;

    @SerializedName(value = "created_at")
    private String createdAt;

    public Customer() {
    }

    public Customer(String id, String object, String email, String name, String ip, String ipCountry, String country, String locale, String createdAt) {
        this.id = id;
        this.object = object;
        this.email = email;
        this.name = name;
        this.ip = ip;
        this.ipCountry = ipCountry;
        this.country = country;
        this.locale = locale;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpCountry() {
        return ipCountry;
    }

    public void setIpCountry(String ipCountry) {
        this.ipCountry = ipCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
