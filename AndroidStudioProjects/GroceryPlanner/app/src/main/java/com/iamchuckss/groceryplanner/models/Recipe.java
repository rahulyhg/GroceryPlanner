package com.iamchuckss.groceryplanner.models;

import java.util.ArrayList;

public class Recipe {

    String title;
    String description;
    String website;
    ArrayList<Ingredient> ingredients;

    public Recipe(String title, String description, String website, ArrayList<Ingredient> ingredients) {
        this.title = title;
        this.description = description;
        this.website = website;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
