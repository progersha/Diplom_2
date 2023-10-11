package org.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.register.RegisterUser;
import org.praktikum.user.DeleteUser;
import org.praktikum.user.User;

import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTest {

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
    @DisplayName("Логин под существующим пользователем")
    public void loginCorrectTest() {
        User user = new User(email, password);
        LoginUser loginUser = new LoginUser(user);
        loginUser.loginUser()
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Логин с неверным логином и паролем")
    public void loginWithInvalidNameAndPassword() {
        User invalidUser = new User(email + " ", password + " ");
        LoginUser loginUser = new LoginUser(invalidUser);
        loginUser.loginUser()
                .assertThat()
                .statusCode(401)
                .and()
                .body("message", equalTo("email or password are incorrect"));
    }

    @After
    public void deleteUserAfter() {
        deleteUser.deleteUser(accessToken);
    }
}
