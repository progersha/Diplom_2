package org.praktikum.get_orders;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.order.CreateOrder;
import org.praktikum.order.GetIngredientsIList;
import org.praktikum.order.GetUserOrder;
import org.praktikum.register.RegisterUser;
import org.praktikum.user.DeleteUser;
import org.praktikum.user.User;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetOrderTest {

    private final String email = "email123567@mail.ri";
    private final String password = "password";
    private final String name = "Name";
    private String accessToken;

    List<String> ingredients = new GetIngredientsIList().getIngredients();

    User user = new User(email, password, name);
    RegisterUser registerUser = new RegisterUser(user);
    CreateOrder order = new CreateOrder();
    GetUserOrder getUserOrder = new GetUserOrder();
    DeleteUser deleteUser  = new DeleteUser(user);

    @Before
    public void createOrder() {
        accessToken = registerUser.getAccessToken();
        order.createOrder(accessToken, ingredients);
    }

    @Test
    @DisplayName("Получение заказов конкретного пользователя с авторизацией")
    public void getOrdersWithAuthTest() {
        getUserOrder.getUserOrderWithAuth(accessToken)
                .assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Получение заказов конкретного пользователя без авторизации")
    public void getOrdersWithoutAuthTest() {
        getUserOrder.getUserOrderWithoutAuth()
                .assertThat()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @After
    public void deleteUserAfter() {
        deleteUser.deleteUser(accessToken);
    }
}
