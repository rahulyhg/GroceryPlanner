package com.iamchuckss.groceryplanner.models;

import java.util.ArrayList;

public class Recipe {

    String title;
    String website;
    ArrayList<Ingredient> ingredients;
    boolean checked;

    public Recipe(String title, String website, ArrayList<Ingredient> ingredients) {
        this.title = title;
        this.website = website;
        this.ingredients = ingredients;
        checked = false;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", website='" + website + '\'' +
                ", ingredients=" + ingredients +
                ", checked=" + checked +
                '}';
    }
}
