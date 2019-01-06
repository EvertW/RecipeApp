package nl.evertwoud.recipeapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse {
    @SerializedName("count")
    public int count;
    @SerializedName("recipes")
    public List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
