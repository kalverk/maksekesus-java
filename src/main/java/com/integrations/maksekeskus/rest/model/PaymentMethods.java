package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMethods {

    @SerializedName(value = "banklinks")
    private List<BankLink> bankLinks;

    @SerializedName(value = "other")
    private List<OtherPaymentMethodValues> other;

    public PaymentMethods() {
    }

    public PaymentMethods(List<BankLink> bankLinks, List<OtherPaymentMethodValues> other) {
        this.bankLinks = bankLinks;
        this.other = other;
    }

    public List<BankLink> getBankLinks() {
        return bankLinks;
    }

    public void setBankLinks(List<BankLink> bankLinks) {
        this.bankLinks = bankLinks;
    }

    public List<OtherPaymentMethodValues> getOther() {
        return other;
    }

    public void setOther(List<OtherPaymentMethodValues> other) {
        this.other = other;
    }
}
