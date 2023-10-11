package org.praktikum.register;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;
import org.praktikum.user.User;

public class RegisterUser extends StellarburgersHttpClient {

    User user;

    public RegisterUser(User user) {
        this.user = user;
    }

    public ValidatableResponse registerUser() {
        return doPostRequest(REGISTER_URL, user);
    }

    public String getAccessToken() {
        return registerUser().extract().body().as(Token.class).getAccessToken();
    }
}
