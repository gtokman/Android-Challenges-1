package com.garytokman.tokmangary_recipeapp.model;

/**
 * Created by gtokman1 on 8/23/16.
 */
public class Recipe {

    private String mRecipeImage;
    private String mRecipeTitle;
    private String mRecipePublisher;

    public Recipe(String recipeImage, String recipeTitle, String recipePublisher) {
        mRecipeImage = recipeImage;
        mRecipeTitle = recipeTitle;
        mRecipePublisher = recipePublisher;
    }

    @Override
    public String toString() {
        return mRecipeTitle;
    }

    public String getRecipeImage() {
        return mRecipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        mRecipeImage = recipeImage;
    }

    public String getRecipeTitle() {
        return mRecipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        mRecipeTitle = recipeTitle;
    }

    public String getRecipePublisher() {
        return mRecipePublisher;
    }

    public void setRecipePublisher(String recipePublisher) {
        mRecipePublisher = recipePublisher;
    }
}
