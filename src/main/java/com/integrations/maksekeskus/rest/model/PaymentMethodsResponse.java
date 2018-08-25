package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMethodsResponse {
    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "name")
    private String name;

    @SerializedName(value = "object")
    private String object;

    @SerializedName(value = "created_at")
    private String createdAt;

    @SerializedName(value = "modified_at")
    private String modifiedAt;

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "contact")
    private Contact contact;

    @SerializedName(value = "features")
    private List<Feature> features;

    @SerializedName(value = "notifications")
    private Notifications notifications;

    @SerializedName(value = "paymentMethods")
    private PaymentMethods paymentMethods;

    @SerializedName(value = "return")
    private Return returnObject;

    public PaymentMethodsResponse() {
    }

    public PaymentMethodsResponse(String id, String name, String object, String createdAt, String modifiedAt, String status, Contact contact, List<Feature> features, Notifications notifications, PaymentMethods paymentMethods, Return returnObject) {
        this.id = id;
        this.name = name;
        this.object = object;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.status = status;
        this.contact = contact;
        this.features = features;
        this.notifications = notifications;
        this.paymentMethods = paymentMethods;
        this.returnObject = returnObject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Return getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Return returnObject) {
        this.returnObject = returnObject;
    }
}
