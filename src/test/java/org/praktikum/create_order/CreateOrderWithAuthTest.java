package org.praktikum.create_order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.order.CreateOrder;
import org.praktikum.order.GetIngredientsIList;
import org.praktikum.register.RegisterUser;
import org.praktikum.user.DeleteUser;
import org.praktikum.user.User;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateOrderWithAuthTest {

    private final String email = "email123567@mail.ri";
    private final String password = "password";
    private final String name = "Name";
    private String accessToken;

    List<String> ingredients = new GetIngredientsIList().getIngredients();
    List<String> invalidHashIngredients = new GetIngredientsIList().getInvalidHashIngredients();

    User user = new User(email, password, name);
    RegisterUser registerUser = new RegisterUser(user);
    CreateOrder order = new CreateOrder();
    DeleteUser deleteUser  = new DeleteUser(user);

    @Before
    public void createUser() {
        accessToken = registerUser.getAccessToken();
    }

    @Test
    @DisplayName("Создание заказа с ингредиентами")
    public void createOrderWithIngredientsTest() {
        order.createOrder(accessToken, ingredients)
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", equalTo(true));
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

    @After
    public void deleteUserAfter() {
        deleteUser.deleteUser(accessToken);
    }
}
