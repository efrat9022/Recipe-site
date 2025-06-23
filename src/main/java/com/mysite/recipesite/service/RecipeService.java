package com.mysite.recipesite.service;
import java.util.List;
import com.mysite.recipesite.model.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(int id);
    Recipe getRecipeById(int id);
    List<Recipe> getAllRecipes();
}
