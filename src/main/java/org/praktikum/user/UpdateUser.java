package org.praktikum.user;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

public class UpdateUser extends StellarburgersHttpClient {

    User user;

    public UpdateUser(User user) {
        this.user = user;
    }

    public ValidatableResponse updateUser(String accessToken, Object data) {
        return doPatchRequest(AUTH_URL, accessToken, data);
    }
}
