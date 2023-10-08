package org.praktikum.login;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;
import org.praktikum.user.User;

public class LoginUser extends StellarburgersHttpClient {

    User user;

    public LoginUser(User user) {
        this.user = user;
    }

    public ValidatableResponse loginUser() {
        return doPostRequest(LOGIN_URL, user);
    }
}
