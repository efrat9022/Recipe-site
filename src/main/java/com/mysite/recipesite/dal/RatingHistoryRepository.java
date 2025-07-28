package com.mysite.recipesite.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mysite.recipesite.model.RatingHistory;

@Repository
public interface RatingHistoryRepository extends CrudRepository<RatingHistory, Integer> {

    List<RatingHistory> findByUseridAndRatingDate(int userid, LocalDate ratingDate);

    List<RatingHistory> findByUseridAndRecipeidAndRatingDate(int userid, int recipeid, LocalDate ratingDate);

    List<RatingHistory> findByRatingDateBetween(LocalDate start, LocalDate end);

    List<RatingHistory> findByRecipeid(int recipeid);
}
