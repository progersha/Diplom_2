package org.praktikum.order;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

public class GetUserOrder extends StellarburgersHttpClient {

    public ValidatableResponse getUserOrderWithAuth(String token) {
        return doGetRequest(ORDERS_URL, token);
    }

    public ValidatableResponse getUserOrderWithoutAuth() {
        return doGetRequest(ORDERS_URL);
    }
}
