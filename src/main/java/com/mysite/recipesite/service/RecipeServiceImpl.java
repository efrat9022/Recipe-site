package com.mysite.recipesite.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.recipesite.dal.RecipeRepository;
import com.mysite.recipesite.dal.UserRepository;
import com.mysite.recipesite.dto.RecipeDTO;
import com.mysite.recipesite.model.Recipe;
import com.mysite.recipesite.model.User;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void add(RecipeDTO r) {
        if (recipeRepo.existsByid(r.getId())) {
            throw new RuntimeException("Username already exists");
        }
        recipeRepo.save(mapper.map(r, Recipe.class));
    }

    @Override
    public void update(RecipeDTO r) {
        if (!recipeRepo.existsByid(r.getId())) {
            throw new RuntimeException("Recipe does not exist");
        }
        recipeRepo.save(mapper.map(r, Recipe.class));
    }

   @Override
    public void delete(int id) {
        recipeRepo.deleteById(id);
    }

    @Override
    public List<RecipeDTO> getAll() {
        Type t=new TypeToken<List<RecipeDTO>>(){}.getType();
        return mapper.map((List<Recipe>) recipeRepo.findAll(),t);
    }

    @Override
    public RecipeDTO getBytitle(String title) {
        return mapper.map(recipeRepo.findBytitle(title), RecipeDTO.class);
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
