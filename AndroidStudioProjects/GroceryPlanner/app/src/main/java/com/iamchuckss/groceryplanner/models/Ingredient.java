package com.iamchuckss.groceryplanner.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Ingredient implements Serializable{

    private String ingredient_id;
    private String title;
    private Integer quantity;
    private boolean checked;

    public Ingredient(String ingredient_id, String title) {
        this.ingredient_id = ingredient_id;
        this.title = title;
        this.quantity = 0;
        this.checked = false;
    }

    public Ingredient() {
    }

    public String getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(String ingredient_id) {
        this.ingredient_id = ingredient_id;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient_id='" + ingredient_id + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", checked=" + checked +
                '}';
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
