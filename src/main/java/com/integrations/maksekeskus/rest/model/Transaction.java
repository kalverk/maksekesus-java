package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName(value = "amount")
    private double amount;

    @SerializedName(value = "currency")
    private String currency;

    @SerializedName(value = "reference")
    private String reference;

    @SerializedName(value = "merchant_data")
    private String merchantData;

    @SerializedName(value = "transaction_url")
    private TransactionUrls transactionUrls;

    public Transaction() {
    }

    public Transaction(double amount, String currency, String reference, String merchantData, TransactionUrls transactionUrls) {
        this.amount = amount;
        this.currency = currency;
        this.reference = reference;
        this.merchantData = merchantData;
        this.transactionUrls = transactionUrls;
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

    public String getMerchantData() {
        return merchantData;
    }

    public void setMerchantData(String merchantData) {
        this.merchantData = merchantData;
    }

    public TransactionUrls getTransactionUrls() {
        return transactionUrls;
    }

    public void setTransactionUrls(TransactionUrls transactionUrls) {
        this.transactionUrls = transactionUrls;
    }
}
