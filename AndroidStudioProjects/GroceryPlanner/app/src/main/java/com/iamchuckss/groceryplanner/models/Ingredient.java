package com.iamchuckss.groceryplanner.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Ingredient implements Serializable{

    private String title;
    private Integer quantity;
    private boolean checked;

    public Ingredient(String title) {
        this.title = title;
        this.quantity = 0;
        this.checked = false;
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
                "title='" + title + '\'' +
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
