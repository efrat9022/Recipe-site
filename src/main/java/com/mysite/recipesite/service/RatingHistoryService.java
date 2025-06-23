package com.mysite.recipesite.service;
import java.util.List;
import com.mysite.recipesite.model.RatingHistory;

public interface RatingHistoryService {

    List<RatingHistory> getAllRatings();
    List<RatingHistory> getRatingsByUser(int userId);
    List<RatingHistory> getRatingsByRecipe(int recipeId);
    RatingHistory addRating(RatingHistory rating);
    void deleteRating(int id);
}
