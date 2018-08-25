package com.integrations.maksekeskus.rest;

import com.integrations.maksekeskus.rest.model.Environment;
import com.integrations.maksekeskus.rest.model.PaymentMethodsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentMethodsClient {

    @GET("/v1/shop/configuration")
    Call<PaymentMethodsResponse> fetchPaymentMethods(@Query("environment") Environment environment);

}
