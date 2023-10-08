package org.praktikum.user;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

public class DeleteUser extends StellarburgersHttpClient {

    User user;

    public DeleteUser(User user) {
        this.user = user;
    }

    public ValidatableResponse deleteUser(String token) {
        return doDeleteRequest(AUTH_URL, token);
    }
}
