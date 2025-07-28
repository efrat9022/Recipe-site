package com.mysite.recipesite.service;

import java.util.List;

import com.mysite.recipesite.dto.RecipeDTO;

public interface RecipeService {
 void add(RecipeDTO r);
 void update(RecipeDTO r);
 void delete(int id);
 List<RecipeDTO> getAll();
 RecipeDTO getBytitle(String title);
 List<String> getAllRecipesbyUserName(String username);
}
