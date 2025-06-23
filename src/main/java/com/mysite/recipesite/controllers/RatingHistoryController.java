package com.mysite.recipesite.controllers;
import com.mysite.recipesite.model.RatingHistory;
import com.mysite.recipesite.service.RatingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingHistoryController {

    @Autowired
    private RatingHistoryService ratingHistoryService;

    @GetMapping
    public List<RatingHistory> getAllRatings() {
        return ratingHistoryService.getAllRatings();
    }

    @GetMapping("/user/{userId}")
    public List<RatingHistory> getRatingsByUser(@PathVariable int userId) {
        return ratingHistoryService.getRatingsByUser(userId);
    }

    @GetMapping("/recipe/{recipeId}")
    public List<RatingHistory> getRatingsByRecipe(@PathVariable int recipeId) {
        return ratingHistoryService.getRatingsByRecipe(recipeId);
    }

    @PostMapping
    public RatingHistory addRating(@RequestBody RatingHistory rating) {
        return ratingHistoryService.addRating(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable int id) {
        ratingHistoryService.deleteRating(id);
    }
}