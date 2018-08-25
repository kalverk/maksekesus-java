package com.integrations.maksekeskus.services;

import com.google.gson.Gson;
import com.integrations.maksekeskus.RestBodyHelper;
import com.integrations.maksekeskus.exceptions.ApiException;
import com.integrations.maksekeskus.rest.model.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTransactionClientTest {

    private static final String USERNAME = "johnsmith";
    private static final String PASSWORD = "password";

    private MockWebServer mockWebServer;
    private PaymentTransactionService paymentTransactionService;
    private Gson gson;

    @BeforeEach
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        paymentTransactionService = new PaymentTransactionService(mockWebServer.url("/").toString(), USERNAME, PASSWORD);

        gson = new Gson();
    }

    @Test
    void fetchPaymentMethods() throws IOException, ApiException {
        String queryBodyFilename = "src/test/resources/createPaymentTransaction.json";
        String queryBodyString = RestBodyHelper.fileToString(queryBodyFilename);
        PaymentTransaction paymentTransaction = gson.fromJson(queryBodyString, PaymentTransaction.class);

        String responseFilename = "src/test/resources/createPaymentTransactionResponse.json";
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(RestBodyHelper.fileToString(responseFilename));
        mockWebServer.enqueue(mockResponse);

        SuccesfulResponse<TransactionResponse> transactionResponse = paymentTransactionService.createPaymentTransaction(paymentTransaction);
        assertNotNull(transactionResponse.getResult());
        assertEquals(transactionResponse.getResult().getAmount(), 12.95);
        assertEquals(transactionResponse.getResult().getCountry(), "ee");
        assertEquals(transactionResponse.getResult().getCreatedAt(), "2018-08-24T15:05:17+0000");
        assertEquals(transactionResponse.getResult().getCurrency(), "EUR");
        assertEquals(transactionResponse.getResult().getId(), "fbbe4249-0078-4408-8903-fc01d0366c3b");
        assertEquals(transactionResponse.getResult().getMerchantData(), "additional data regarding the payment");
        assertNull(transactionResponse.getResult().getMethod());
        assertEquals(transactionResponse.getResult().getObject(), "transaction");
        assertFalse(transactionResponse.getResult().isRecurringRequired());
        assertEquals(transactionResponse.getResult().getReference(), "123abc");
        assertEquals(transactionResponse.getResult().getStatus(), "CREATED");
        assertNull(transactionResponse.getResult().getType());

        Links links = transactionResponse.getResult().getLinks();
        assertNotNull(links);

        assertNotNull(links.getPay());
        assertEquals(links.getPay().getHref(), "https://api.maksekeskus.ee/v1/transactions/fbbe4249-0078-4408-8903-fc01d0366c3b/payments");

        assertNotNull(links.getSelf());
        assertEquals(links.getSelf().getHref(), "https://api.maksekeskus.ee/v1/transactions/fbbe4249-0078-4408-8903-fc01d0366c3b");

        Customer customer = transactionResponse.getResult().getCustomer();
        assertNotNull(customer);
        assertEquals(customer.getCountry(), "ee");
        assertEquals(customer.getCreatedAt(), "2018-08-24T15:05:17+0000");
        assertEquals(customer.getEmail(), "maksekeskus.test.1535101915@mailinator.com");
        assertEquals(customer.getId(), "ad15d548-d55f-4872-b09c-d01a025f811d");
        assertEquals(customer.getIp(), "80.235.22.114");
        assertEquals(customer.getIpCountry(), "ee");
        assertEquals(customer.getLocale(), "et");
        assertEquals(customer.getName(), "ad15d548-d55f-4872-b09c-d01a025f811d");
        assertEquals(customer.getObject(), "customer");

        PaymentMethods paymentMethods = transactionResponse.getResult().getPaymentMethods();
        assertNotNull(paymentMethods);

        List<BankLink> bankLinks = paymentMethods.getBankLinks();
        assertEquals(bankLinks.size(), 7);
        for (BankLink bankLink : bankLinks) {
            assertNotNull(bankLink.getCountry());
            assertNotNull(bankLink.getLogoUrl());
            assertNotNull(bankLink.getName());
            assertNotNull(bankLink.getUrl());
        }

        List<OtherPaymentMethodValues> otherMethods = paymentMethods.getOther();
        assertEquals(otherMethods.size(), 1);
        for (OtherPaymentMethodValues otherMethod : otherMethods) {
            assertNotNull(otherMethod.getName());
            assertNotNull(otherMethod.getUrl());
        }
    }

    @Test
    void fetchPaymentMethodsUnauthorized() {
        assertThrows(ApiException.class,
                () -> {
                    paymentTransactionService = new PaymentTransactionService(mockWebServer.url("/").toString(), null, null);

                    String filename = "src/test/resources/fetchPaymentMethodsUnauthorized.json";
                    MockResponse mockResponse = new MockResponse()
                            .setResponseCode(401)
                            .setBody(RestBodyHelper.fileToString(filename));
                    mockWebServer.enqueue(mockResponse);

                    String queryBodyFilename = "src/test/resources/createPaymentTransaction.json";
                    String queryBodyString = RestBodyHelper.fileToString(queryBodyFilename);
                    PaymentTransaction paymentTransaction = gson.fromJson(queryBodyString, PaymentTransaction.class);

                    paymentTransactionService.createPaymentTransaction(paymentTransaction);
                });
    }

    @Test
    void fetchPaymentMethodsServerError() {
        assertThrows(ApiException.class,
                () -> {
                    String filename = "src/test/resources/fetchPaymentMethodsServerError.json";
                    MockResponse mockResponse = new MockResponse()
                            .setResponseCode(500)
                            .setBody(RestBodyHelper.fileToString(filename));
                    mockWebServer.enqueue(mockResponse);

                    String queryBodyFilename = "src/test/resources/createPaymentTransaction.json";
                    String queryBodyString = RestBodyHelper.fileToString(queryBodyFilename);
                    PaymentTransaction paymentTransaction = gson.fromJson(queryBodyString, PaymentTransaction.class);

                    paymentTransactionService.createPaymentTransaction(paymentTransaction);
                });
    }

    @AfterEach
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

}
