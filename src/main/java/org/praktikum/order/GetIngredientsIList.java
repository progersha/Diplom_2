package org.praktikum.order;

import io.restassured.response.ValidatableResponse;
import org.praktikum.StellarburgersHttpClient;

import java.util.ArrayList;
import java.util.List;

public class GetIngredientsIList extends StellarburgersHttpClient {

    public List<String> IngredientsList = new ArrayList<>();

    public List<String> getIngredients() {
        ValidatableResponse response = doGetRequest(INGREDIENTS_URL);
        List<Ingredient> ingredients = response.extract().body().as(IngredientsList.class).getData();
        ingredients.forEach(i -> IngredientsList.add(i.get_id()));

        return IngredientsList;
    }

    public List<String> getInvalidHashIngredients() {
        ValidatableResponse response = doGetRequest(INGREDIENTS_URL);
        List<Ingredient> ingredients = response.extract().body().as(IngredientsList.class).getData();
        ingredients.forEach(i -> IngredientsList.add(" " + i.get_id()));

        return IngredientsList;
    }
}
