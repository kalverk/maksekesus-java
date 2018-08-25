package com.integrations.maksekeskus.services;

import com.integrations.maksekeskus.ServiceGenerator;
import com.integrations.maksekeskus.exceptions.ApiException;
import com.integrations.maksekeskus.rest.PaymentTransactionClient;
import com.integrations.maksekeskus.rest.model.ErrorResponse;
import com.integrations.maksekeskus.rest.model.PaymentTransaction;
import com.integrations.maksekeskus.rest.model.SuccesfulResponse;
import com.integrations.maksekeskus.rest.model.TransactionResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class PaymentTransactionService {

    private final PaymentTransactionClient paymentTransactionClient;

    public PaymentTransactionService(String apiUrl, String username, String password) {
        ServiceGenerator serviceGenerator = new ServiceGenerator(apiUrl);
        this.paymentTransactionClient = serviceGenerator.createService(PaymentTransactionClient.class, username, password);
    }

    public SuccesfulResponse<TransactionResponse> createPaymentTransaction(PaymentTransaction paymentTransaction) throws IOException, ApiException {
        Call<TransactionResponse> transactionResponseCall = paymentTransactionClient.createPaymentTransaction(paymentTransaction);
        Response<TransactionResponse> response = transactionResponseCall.execute();
        if (!response.isSuccessful()) {
            throw new ApiException(new ErrorResponse(response.code(), response.message()));
        }
        return new SuccesfulResponse<>(response.body());
    }
}
