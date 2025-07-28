package com.mysite.recipesite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.recipesite.model.Recipe;
import com.mysite.recipesite.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

  @Autowired
    private RecipeService rc;


    @GetMapping("/gettiteles/{username}")
    public List<String> getTitlesByUser(@PathVariable String username) {
        return rc.getAllRecipesbyUserName(username);
    }

     @PostMapping("/add")
    public void addRecipe(@RequestBody Recipe r) {
        rc.add(r);
    }

    @PutMapping("/update")
    public void updateRecipe(@RequestBody Recipe r) {
        rc.update(r);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable int id) {
        rc.delete(id);
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipe() {
        return rc.getAll();
    }

    @GetMapping("/getBytitle/{title}")
    public Recipe getBytitlRecipe(@PathVariable String title) {
        return rc.getBytitle(title);
    }

}
