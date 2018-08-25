package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class TransactionUrls {

    @SerializedName(value = "return_url")
    private TransactionUrl returnUrl;

    @SerializedName(value = "cancel_url")
    private TransactionUrl cancelUrl;

    @SerializedName(value = "notification_url")
    private TransactionUrl notificationUrl;

    public TransactionUrls() {
    }

    public TransactionUrls(TransactionUrl returnUrl, TransactionUrl cancelUrl, TransactionUrl notificationUrl) {
        this.returnUrl = returnUrl;
        this.cancelUrl = cancelUrl;
        this.notificationUrl = notificationUrl;
    }

    public TransactionUrl getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(TransactionUrl returnUrl) {
        this.returnUrl = returnUrl;
    }

    public TransactionUrl getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(TransactionUrl cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public TransactionUrl getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(TransactionUrl notificationUrl) {
        this.notificationUrl = notificationUrl;
    }
}
