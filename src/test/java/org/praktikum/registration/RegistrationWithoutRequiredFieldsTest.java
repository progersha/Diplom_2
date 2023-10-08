package org.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.register.RegisterUser;
import org.praktikum.user.User;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class RegistrationWithoutRequiredFieldsTest {

    private final String email;
    private final String password;
    private final String name;

    public RegistrationWithoutRequiredFieldsTest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Parameterized.Parameters()
    public static Object[][] getFields() {
        return new Object[][]{
                {"", "password", "name"},
                {"email", "", "name"},
                {"email", "password", ""},
        };
    }

    @Test
    @DisplayName("Создание пользователя  с одним незаполненным обязательным полем")
    public void registerWithoutRequiredFieldsTest() {
        User user = new User(email, password, name);
        RegisterUser registerUser = new RegisterUser(user);
        registerUser.registerUser()
                .assertThat()
                .statusCode(403)
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }
}
