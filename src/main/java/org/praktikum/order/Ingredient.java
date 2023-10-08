package org.praktikum.order;

public class Ingredient {

    private String _id;

    public Ingredient(String ingredient_id) {
        this._id = ingredient_id;
    }

    public void set_id(String ingredient_id) {
        this._id = ingredient_id;
    }

    public String get_id() {
        return _id;
    }
}
