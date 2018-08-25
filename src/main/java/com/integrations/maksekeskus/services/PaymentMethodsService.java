package com.integrations.maksekeskus.services;

import com.integrations.maksekeskus.ServiceGenerator;
import com.integrations.maksekeskus.exceptions.ApiException;
import com.integrations.maksekeskus.rest.PaymentMethodsClient;
import com.integrations.maksekeskus.rest.model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class PaymentMethodsService {

    private final PaymentMethodsClient paymentMethodsClient;

    public PaymentMethodsService(String apiUrl, String username, String password) {
        ServiceGenerator serviceGenerator = new ServiceGenerator(apiUrl);
        this.paymentMethodsClient = serviceGenerator.createService(PaymentMethodsClient.class, username, password);
    }

    public SuccesfulResponse<PaymentMethods> fetchPaymentMethods(Environment environment) throws IOException, ApiException {
        SuccesfulResponse<PaymentMethodsResponse> paymentMethodsResponse = fetchPaymentMethodsResponseImpl(environment);
        return paymentMethodsResponse.getResult() != null ? new SuccesfulResponse<>(paymentMethodsResponse.getResult().getPaymentMethods()) : new SuccesfulResponse<>(new PaymentMethods());
    }

    public SuccesfulResponse<PaymentMethodsResponse> fetchPaymentMethodsResponse(Environment environment) throws IOException, ApiException {
        return fetchPaymentMethodsResponseImpl(environment);
    }

    public SuccesfulResponse<PaymentMethodsResponse> fetchPaymentMethodsResponseImpl(Environment environment) throws IOException, ApiException {
        Call<PaymentMethodsResponse> paymentMethodsResponseCall = this.paymentMethodsClient.fetchPaymentMethods(environment);
        Response<PaymentMethodsResponse> response = paymentMethodsResponseCall.execute();
        if (!response.isSuccessful()) {
            throw new ApiException(new ErrorResponse(response.code(), response.message()));
        }
        return new SuccesfulResponse<>(response.body());
    }
}
