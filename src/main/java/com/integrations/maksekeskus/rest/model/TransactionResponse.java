package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class TransactionResponse {

    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "object")
    private String object;

    @SerializedName(value = "created_at")
    private String createdAt;

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "_links")
    private Links links;

    @SerializedName(value = "amount")
    private double amount;

    @SerializedName(value = "currency")
    private String currency;

    @SerializedName(value = "reference")
    private String reference;

    @SerializedName(value = "recurring_required")
    private boolean recurringRequired;

    @SerializedName(value = "customer")
    private Customer customer;

    @SerializedName(value = "country")
    private String country;

    @SerializedName(value = "merchant_data")
    private String merchantData;

    @SerializedName(value = "method")
    private String method;

    @SerializedName(value = "payment_methods")
    private PaymentMethods paymentMethods;

    @SerializedName(value = "type")
    private Object type;

    public TransactionResponse() {
    }

    public TransactionResponse(String id, String object, String createdAt, String status, Links links, double amount, String currency, String reference, boolean recurringRequired, Customer customer, String country, String merchantData, String method, PaymentMethods paymentMethods, Object type) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.status = status;
        this.links = links;
        this.amount = amount;
        this.currency = currency;
        this.reference = reference;
        this.recurringRequired = recurringRequired;
        this.customer = customer;
        this.country = country;
        this.merchantData = merchantData;
        this.method = method;
        this.paymentMethods = paymentMethods;
        this.type = type;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isRecurringRequired() {
        return recurringRequired;
    }

    public void setRecurringRequired(boolean recurringRequired) {
        this.recurringRequired = recurringRequired;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMerchantData() {
        return merchantData;
    }

    public void setMerchantData(String merchantData) {
        this.merchantData = merchantData;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }
}
