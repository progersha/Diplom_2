package org.praktikum.order;

import java.util.List;

public class IngredientsList {

    private List<Ingredient> data;

    public IngredientsList(List<Ingredient> ingredientsList) {
        this.data = ingredientsList;
    }

    public void setData(List<Ingredient> data) {
        this.data = data;
    }

    public List<Ingredient> getData() {
        return data;
    }
}
