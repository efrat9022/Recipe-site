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

    // שליפת כל הדירוגים
    @GetMapping
    public List<RatingHistory> getAllRatings() {
        return ratingHistoryService.getAllRatings();
    }

    // שליפת דירוגים לפי מזהה משתמש
    @GetMapping("/user/{userId}")
    public List<RatingHistory> getRatingsByUser(@PathVariable int userId) {
        return ratingHistoryService.getRatingsByUser(userId);
    }

    // שליפת דירוגים לפי מזהה מתכון
    @GetMapping("/recipe/{recipeId}")
    public List<RatingHistory> getRatingsByRecipe(@PathVariable int recipeId) {
        return ratingHistoryService.getRatingsByRecipe(recipeId);
    }

    // הוספת דירוג חדש
    @PostMapping
    public RatingHistory addRating(@RequestBody RatingHistory rating) {
        return ratingHistoryService.addRating(rating);
    }

    // מחיקת דירוג לפי מזהה
    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable int id) {
        ratingHistoryService.deleteRating(id);
    }
}