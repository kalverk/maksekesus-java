package com.integrations.maksekeskus.services;

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

public class PaymentMethodsTest {

    private static final String USERNAME = "johnsmith";
    private static final String PASSWORD = "password";

    private MockWebServer mockWebServer;
    private PaymentMethodsService paymentMethods;

    @BeforeEach
    public void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        paymentMethods = new PaymentMethodsService(mockWebServer.url("/").toString(), USERNAME, PASSWORD);
    }

    @Test
    void fetchPaymentMethods() throws IOException, ApiException {
        String filename = "src/test/resources/fetchPaymentMethodsResponse.json";
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(RestBodyHelper.fileToString(filename));
        mockWebServer.enqueue(mockResponse);

        Environment environment = new Environment("magento 2.x", "mk-payment 0.1");
        SuccesfulResponse<PaymentMethods> paymentMethods = this.paymentMethods.fetchPaymentMethods(environment);
        assertNotNull(paymentMethods.getResult());

        List<BankLink> bankLinks = paymentMethods.getResult().getBankLinks();
        assertEquals(bankLinks.size(), 24);
        for (BankLink bankLink : bankLinks) {
            assertNotNull(bankLink.getCountry());
            assertNotNull(bankLink.getLogoUrl());
            assertNotNull(bankLink.getName());
            assertNotNull(bankLink.getUrl());
        }
    }

    @Test
    void fetchPaymentMethodsResponse() throws IOException, ApiException {
        String filename = "src/test/resources/fetchPaymentMethodsResponse.json";
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(RestBodyHelper.fileToString(filename));
        mockWebServer.enqueue(mockResponse);

        Environment environment = new Environment("magento 2.x", "mk-payment 0.1");
        SuccesfulResponse<PaymentMethodsResponse> paymentMethodsResponse = this.paymentMethods.fetchPaymentMethodsResponse(environment);

        assertNotNull(paymentMethodsResponse.getResult());
        assertEquals(paymentMethodsResponse.getResult().getId(), "1ca58c6f-89c2-442f-950a-cd5fa3484397");
        assertEquals(paymentMethodsResponse.getResult().getName(), "MK Test Shop Live (3Ds OCP $ EP)");
        assertEquals(paymentMethodsResponse.getResult().getObject(), "shop");
        assertEquals(paymentMethodsResponse.getResult().getCreatedAt(), "2013-08-26T09:46:09+0000");
        assertEquals(paymentMethodsResponse.getResult().getModifiedAt(), "2018-07-31T02:00:26+0000");
        assertEquals(paymentMethodsResponse.getResult().getStatus(), "ACTIVE");

        Contact contact = paymentMethodsResponse.getResult().getContact();
        assertNotNull(contact);
        assertEquals(contact.getEmail(), "maksekeskus.test@mailinator.com");
        assertEquals(contact.getPhone(), "+37255555555");

        List<Feature> featureList = paymentMethodsResponse.getResult().getFeatures();
        assertEquals(featureList.size(), 1);
        for (Feature feature : featureList) {
            assertNotNull(feature.getName());
            assertNotNull(feature.getObject());
        }

        Notifications notifications = paymentMethodsResponse.getResult().getNotifications();
        assertNotNull(notifications);
        assertEquals(notifications.getEmail(), "maksekeskus.test@mailinator.com");
        assertEquals(notifications.getMethod(), "POST");
        assertEquals(notifications.getUrl(), "http://maksekeskus.ee/test/notify.php?env=laiv&email=maksekeskus.test@mailinator.com");

        PaymentMethods paymentMethods = paymentMethodsResponse.getResult().getPaymentMethods();
        assertNotNull(paymentMethods);

        List<BankLink> bankLinks = paymentMethods.getBankLinks();
        assertEquals(bankLinks.size(), 24);
        for (BankLink bankLink : bankLinks) {
            assertNotNull(bankLink.getCountry());
            assertNotNull(bankLink.getLogoUrl());
            assertNotNull(bankLink.getName());
            assertNotNull(bankLink.getUrl());
        }

        Return returnObject = paymentMethodsResponse.getResult().getReturnObject();
        assertNotNull(returnObject);
        assertEquals(returnObject.getMethod(), "POST");
        assertEquals(returnObject.getUrl(), "https://developer.maksekeskus.ee/return.php?type=return&env=laiv");
    }

    @Test
    void fetchPaymentMethodsUnauthorized() {
        assertThrows(ApiException.class,
                () -> {
                    paymentMethods = new PaymentMethodsService(mockWebServer.url("/").toString(), null, null);

                    String filename = "src/test/resources/fetchPaymentMethodsUnauthorized.json";
                    MockResponse mockResponse = new MockResponse()
                            .setResponseCode(401)
                            .setBody(RestBodyHelper.fileToString(filename));
                    mockWebServer.enqueue(mockResponse);

                    Environment environment = new Environment("magento 2.x", "mk-payment 0.1");
                    this.paymentMethods.fetchPaymentMethodsResponse(environment);
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

                    Environment environment = new Environment("magento 2.x", "mk-payment 0.1");
                    this.paymentMethods.fetchPaymentMethodsResponse(environment);
                });
    }

    @AfterEach
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

}
