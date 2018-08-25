package com.integrations.maksekeskus.rest.model;

import com.google.gson.annotations.SerializedName;

public class PaymentTransaction {

    @SerializedName(value = "transaction")
    private Transaction transaction;

    @SerializedName(value = "customer")
    private Customer customer;

    public PaymentTransaction() {
    }

    public PaymentTransaction(Transaction transaction, Customer customer) {
        this.transaction = transaction;
        this.customer = customer;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
