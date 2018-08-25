package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName(value = "Pay")
    private LinkUrl pay;

    @SerializedName(value = "self")
    private LinkUrl self;

    public Links() {
    }

    public Links(LinkUrl pay, LinkUrl self) {
        this.pay = pay;
        this.self = self;
    }

    public LinkUrl getPay() {
        return pay;
    }

    public void setPay(LinkUrl pay) {
        this.pay = pay;
    }

    public LinkUrl getSelf() {
        return self;
    }

    public void setSelf(LinkUrl self) {
        this.self = self;
    }
}
