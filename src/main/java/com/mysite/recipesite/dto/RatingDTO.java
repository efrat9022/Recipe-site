package com.mysite.recipesite.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RatingDTO {
    private int id;
    private int userid;
    private int recipeid;
    private int ratingValue; // 1-5 כוכבים
    private LocalDate ratingDate;

    private String userName;
    private String recipeTitle;
}
