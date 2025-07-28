package com.mysite.recipesite.controllers;

import com.mysite.recipesite.dto.RatingDTO;
import com.mysite.recipesite.service.RatingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingHistoryService rs;

    // שליחת דירוג חדש
    @PostMapping("/add")
    public void addRating(@RequestBody RatingDTO rating) {
        rs.addRating(rating);
    }

    // כל הדירוגים של מתכון מסוים
    @GetMapping("/recipe/{recipeId}")
    public List<RatingDTO> getRatingsForRecipe(@PathVariable int recipeId) {
        return rs.getRatingsForRecipe(recipeId);
    }

    // כל הדירוגים במערכת (לבדיקה כללית)
    @GetMapping("/all")
    public List<RatingDTO> getAllRatings() {
        return rs.getAllRatings();
    }

    // המתכונים המדורגים ביותר בשבוע האחרון
    @GetMapping("/top-week")
    public List<RatingDTO> getTopRatedRecipesOfWeek() {
        return rs.getTopRatedRecipesOfWeek();
    }
}
