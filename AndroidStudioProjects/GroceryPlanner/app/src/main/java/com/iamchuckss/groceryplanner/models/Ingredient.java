package com.iamchuckss.groceryplanner.models;

public class Ingredient {

    private String title;
    private Integer quantity;

    public Ingredient(String title, Integer quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
