package com.mysite.recipesite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.recipesite.dal.RecipeRepository;
import com.mysite.recipesite.dal.UserRepository;
import com.mysite.recipesite.model.Recipe;
import com.mysite.recipesite.model.User;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public void add(Recipe r) {
        if (recipeRepo.existsByid(r.getId())) {
            throw new RuntimeException("Username already exists");
        }
        recipeRepo.save(r);
    }

    @Override
    public void update(Recipe r) {
        if (!recipeRepo.existsByid(r.getId())) {
            throw new RuntimeException("Recipe does not exist");
        }
        recipeRepo.save(r);
    }

   @Override
    public void delete(int id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public List<Recipe> getAll() {
        return (List<Recipe>) recipeRepo.findAll();
    }

    @Override
    public Recipe getBytitle(String title) {
        return recipeRepo.findBytitle(title);
    }

    @Override
    public List<String> getAllRecipesbyUserName(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username: " + username);
        }
        return user.getRecipes().stream()
                .map(Recipe::getTitle)
                .toList();
    }

}
