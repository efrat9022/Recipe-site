package com.mysite.recipesite.controllers;

import com.mysite.recipesite.model.Recipe;
import com.mysite.recipesite.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // הוספת מתכון
    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    // עדכון מתכון
    @PutMapping
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeService.updateRecipe(recipe);
    }

    // מחיקת מתכון לפי ID
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }

    // קבלת כל המתכונים
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

  // קבלת מתכון לפי ID
@GetMapping("/{id}")
public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
    Recipe recipe = recipeService.getRecipeById(id);
    if (recipe == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(recipe);
}

}
