package com.mysite.recipesite.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Type;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.recipesite.dal.RatingHistoryRepository;
import com.mysite.recipesite.dal.RecipeRepository;
import com.mysite.recipesite.dto.RatingDTO;
import com.mysite.recipesite.model.RatingHistory;
import com.mysite.recipesite.model.Recipe;

@Service
public class RatingHistoryServiceImpl implements RatingHistoryService {

     @Autowired
    private RatingHistoryRepository ratingRepo;

    @Autowired
    private RecipeRepository recipeRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRating(RatingDTO rating) {
        int userid = rating.getUserid();
        int recipeid = rating.getRecipeid();
        LocalDate today = LocalDate.now();

        boolean alreadyRated = !ratingRepo
                .findByUseridAndRecipeidAndRatingDate(userid, recipeid, today)
                .isEmpty();

        if (alreadyRated) {
            throw new RuntimeException("User has already rated this recipe today.");
        }

        RatingHistory entity = mapper.map(rating, RatingHistory.class);
        entity.setRatingDate(today); 
        ratingRepo.save(entity);
    }

    @Override
    public List<RatingDTO> getRatingsForRecipe(int recipeId) {
        List<RatingHistory> ratings = ratingRepo.findByRecipeid(recipeId);
        Type listType = new TypeToken<List<RatingDTO>>() {}.getType();
        return mapper.map(ratings, listType);
    }

    @Override
    public List<RatingDTO> getAllRatings() {
        List<RatingHistory> ratings = (List<RatingHistory>) ratingRepo.findAll();
        Type listType = new TypeToken<List<RatingDTO>>() {}.getType();
        return mapper.map(ratings, listType);
    }

    @Override
public List<RatingDTO> getTopRatedRecipesOfWeek() {
    LocalDate today = LocalDate.now();
    LocalDate weekAgo = today.minus(7, ChronoUnit.DAYS);

    List<RatingHistory> ratingsThisWeek = ratingRepo.findByRatingDateBetween(weekAgo, today);

    // חישוב ממוצע דירוגים לכל מתכון
    Map<Integer, Double> averageRatings = ratingsThisWeek.stream()
            .collect(Collectors.groupingBy(
                    RatingHistory::getRecipeid,
                    Collectors.averagingInt(RatingHistory::getRatingValue)
            ));

    // מיפוי המתכונים לדירוגים
    return averageRatings.entrySet().stream()
            .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())) // דירוג יורד
            .limit(3)
            .map(entry -> {
                Recipe recipe = recipeRepo.findById(entry.getKey()).orElse(null);
                if (recipe == null) return null;
                RatingDTO dto = new RatingDTO();
                dto.setRecipeTitle(recipe.getTitle());
                dto.setRatingValue((int)Math.round(entry.getValue())); // עיגול
                return dto;
            })
            .filter(r -> r != null)
            .collect(Collectors.toList());
}

    
}
