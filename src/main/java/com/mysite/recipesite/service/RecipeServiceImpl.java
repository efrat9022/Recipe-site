package com.mysite.recipesite.service;

import com.mysite.recipesite.dal.RecipeRepository;
import com.mysite.recipesite.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        if (recipeRepository.existsById(recipe.getId())) {
            recipeRepository.save(recipe);
        } else {
            throw new IllegalArgumentException("מתכון עם ID " + recipe.getId() + " לא נמצא");
        }
    }

    @Override
    public void deleteRecipe(int id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("לא ניתן למחוק - מתכון לא קיים");
        }
    }

    @Override
    public Recipe getRecipeById(int id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        return optionalRecipe.orElseThrow(() ->
                new IllegalArgumentException("מתכון עם ID " + id + " לא נמצא"));
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }
}
