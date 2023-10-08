package org.praktikum.create_order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.order.CreateOrder;
import org.praktikum.order.GetIngredientsIList;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateOrderWithoutAuthTest {

    private String accessToken = "";

    List<String> ingredients = new GetIngredientsIList().getIngredients();
    List<String> invalidHashIngredients = new GetIngredientsIList().getInvalidHashIngredients();

    CreateOrder order = new CreateOrder();

    @Test
    @DisplayName("Создание заказа с ингредиентами")
    public void createOrderWithIngredientsTest() {
        order.createOrder(accessToken, ingredients)
                .assertThat()
                .body("success", equalTo(true))
                .and()
                .body("message", equalTo("Ingredient ids must be provided"));
    }

    @Test
    @DisplayName("Создание заказа без ингредиентов")
    public void createOrderWithoutIngredientsTest() {
        order.createEmptyOrder(accessToken)
                .assertThat()
                .statusCode(400)
                .and()
                .body("success", equalTo(false));
    }

    @Test
    @DisplayName("Создание заказа с неверным хешем ингредиентов")
    public void createOrderWithInvalidHashIngredientsTest() {
        order.createOrder(accessToken, invalidHashIngredients)
                .assertThat()
                .statusCode(500);
    }
}
