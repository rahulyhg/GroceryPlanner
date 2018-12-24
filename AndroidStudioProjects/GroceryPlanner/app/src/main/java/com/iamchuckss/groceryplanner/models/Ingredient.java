package com.iamchuckss.groceryplanner.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.iamchuckss.groceryplanner.utils.FirebaseMethods;

import java.io.Serializable;
import java.util.HashMap;

public class Ingredient implements Serializable{

    private String ingredient_id;
    private String title;
    private boolean checked;
    private Integer quantity;

    public Ingredient(String ingredient_id, String title) {
        this.ingredient_id = ingredient_id;
        this.title = title;
        this.checked = false;
        this.quantity = 0;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient_id='" + ingredient_id + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                '}';
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
