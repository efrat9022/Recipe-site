package com.mysite.recipesite.service;

import com.mysite.recipesite.dal.RatingHistoryRepository;
import com.mysite.recipesite.model.RatingHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class RatingHistoryServiceImpl implements RatingHistoryService {

    @Autowired
    private RatingHistoryRepository ratingHistoryRepository;

    @Override
    public List<RatingHistory> getAllRatings() {
        List<RatingHistory> ratings = new ArrayList<>();
        ratingHistoryRepository.findAll().forEach(ratings::add);
        return ratings;
    }

    @Override
    public List<RatingHistory> getRatingsByUser(int userId) {
        return ratingHistoryRepository.findByUserId(userId);
    }

    @Override
    public List<RatingHistory> getRatingsByRecipe(int recipeId) {
        return ratingHistoryRepository.findByRecipeId(recipeId);
    }

    @Override
    public RatingHistory addRating(RatingHistory rating) {
        rating.setDateRated(LocalDate.now());
        return ratingHistoryRepository.save(rating);
    }

    @Override
    public void deleteRating(int id) {
        if (ratingHistoryRepository.existsById(id)) {
            ratingHistoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("לא ניתן למחוק - דירוג לא קיים");
        }
    }
}
