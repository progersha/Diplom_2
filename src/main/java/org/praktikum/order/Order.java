package org.praktikum.order;

import java.util.List;

public class Order {

    private List<String> ingredients;

    public Order(List<String> ingredientsList) {
        this.ingredients = ingredientsList;
    }

    public Order() {}

    public void setIngredients(List<String> ingredientsList) {
        this.ingredients = ingredientsList;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
