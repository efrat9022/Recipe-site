package com.mysite.recipesite.service;

import java.util.List;

import com.mysite.recipesite.dto.RatingDTO;

public interface  RatingHistoryService {

    void addRating(RatingDTO rating);
    List<RatingDTO> getRatingsForRecipe(int recipeId);
    List<RatingDTO> getAllRatings();
    List<RatingDTO> getTopRatedRecipesOfWeek();
}
