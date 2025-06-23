package com.mysite.recipesite.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mysite.recipesite.model.RatingHistory;
import com.mysite.recipesite.model.User;

@Repository
public interface RatingHistoryRepository extends CrudRepository<RatingHistory,Integer> {
    //לעשות- פונקציה שתחזיר את ה5 מתכונים הכי פופלאריים השבוע בסדר עולה

    //בודק אם המשתמש כבר דירג משהו באותו שבוע
    boolean existsByUserAndDateRatedAfter(User user, LocalDate date);
     // מחזיר את כל הדירוגים של משתמש מסוים
    List<RatingHistory> findByUserId(int userId);
    // מחזיר את כל הדירוגים עבור מתכון מסוים
    List<RatingHistory> findByRecipeId(int recipeId);
}
