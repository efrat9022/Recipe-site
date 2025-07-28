package com.mysite.recipesite.service;

import java.util.List;
import com.mysite.recipesite.model.Recipe;

public interface RecipeService {
 void add(Recipe r);
 void update(Recipe r);
 void delete(int id);
 List<Recipe> getAll();
 Recipe getBytitle(String title);
 List<String> getAllRecipesbyUserName(String username);
}
