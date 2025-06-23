package com.mysite.recipesite.dal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mysite.recipesite.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Integer>{
     List<Recipe> findByDateAddedAfterOrderByAverageRatingDesc(LocalDate fromDate);
}
