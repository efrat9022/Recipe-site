package com.mysite.recipesite.dal;

import org.springframework.data.repository.CrudRepository;

import com.mysite.recipesite.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {
    public Recipe findBytitle(String title);
    boolean existsByid(int id);
}
