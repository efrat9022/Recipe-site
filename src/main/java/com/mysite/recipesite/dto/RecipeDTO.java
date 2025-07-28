package com.mysite.recipesite.dto;

import lombok.Data;

@Data
public class RecipeDTO {
   
    private int id;
    private String title; 
    private String description; 
    private String ingredients; 
    private String steps; 
    private String difficulty; 
    private String mediaUrl; 
    private int preparationTime = 0;

    private int userid; 
    private String userName;
}
