package org.praktikum.update_user;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.user.UpdateUser;
import org.praktikum.user.User;
import org.praktikum.user.UserEmail;
import org.praktikum.user.UserName;
import org.praktikum.user.UserPassword;

import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateUserWithoutAuthTest {

    private final String email = "email123567@mail.ri";
    private final String password = "password";
    private final String name = "Name";
    private String accessToken = "";

    User user = new User(email, password, name);
    UpdateUser updateUser = new UpdateUser(user);

    @Test
    @DisplayName("Изменение имейла пользователя")
    public void updateEmailUserTest() {
        UserEmail userEmail = new UserEmail("new" + email);
        updateUser.updateUser(accessToken, userEmail)
                .assertThat()
                .statusCode(401)
                .and()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Изменение пароля пользователя")
    public void updatePasswordUserTest() {
        UserPassword userPassword = new UserPassword("new" + password);
        updateUser.updateUser(accessToken, userPassword)
                .assertThat()
                .statusCode(401)
                .and()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Изменение имени пользователя")
    public void updateNameUserTest() {
        UserName userName = new UserName("new" + name);
        updateUser.updateUser(accessToken, userName)
                .assertThat()
                .statusCode(401)
                .and()
                .body("success", equalTo(false))
                .and()
                .body("message", equalTo("You should be authorised"));
    }
}
