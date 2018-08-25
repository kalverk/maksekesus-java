package com.integrations.maksekeskus.rest;

import com.integrations.maksekeskus.rest.model.PaymentTransaction;
import com.integrations.maksekeskus.rest.model.TransactionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentTransactionClient {

    @POST("/v1/transactions")
    Call<TransactionResponse> createPaymentTransaction(@Body PaymentTransaction paymentTransaction);

}
