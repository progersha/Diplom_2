package org.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.register.RegisterUser;
import org.praktikum.user.DeleteUser;
import org.praktikum.user.User;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrationTest {

    private final String email = "email123567@mail.ri";
    private final String password = "password";
    private final String name = "Name";
    private String accessToken;

    User user = new User(email, password, name);
    RegisterUser registerUser = new RegisterUser(user);
    DeleteUser deleteUser  = new DeleteUser(user);

    @Before
    public void createUser() {
        accessToken = registerUser.getAccessToken();
    }

    @Test
    @DisplayName("Создание уникального пользователя")
    public void registerUserTest() {
        Assert.assertTrue(accessToken.startsWith("Bearer"));
    }

    @Test
    @DisplayName("Создание пользователя, который уже зарегистрирован")
    public void registerAlreadyRegisteredUserTest() {
        registerUser.registerUser()
                .assertThat()
                .statusCode(403)
                .and()
                .body("message", equalTo("User already exists"));
    }

    @After
    public void deleteUserAfter() {
        deleteUser.deleteUser(accessToken);
    }
}
