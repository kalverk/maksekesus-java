package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName(value = "email")
    private String email;

    @SerializedName(value = "phone")
    private String phone;

    public Contact() {
    }

    public Contact(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
