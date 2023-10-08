package org.praktikum.order;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

import java.util.List;

public class CreateOrder extends StellarburgersHttpClient {

    public ValidatableResponse createOrder(String token, List<String> ingredients) {
        Order newOrder = new Order(ingredients);
        return doPostRequest(ORDERS_URL, newOrder, token);
    }

    public ValidatableResponse createEmptyOrder(String token) {
        Order newOrder = new Order();
        return doPostRequest(ORDERS_URL, newOrder, token);
    }
}
