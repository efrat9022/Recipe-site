package com.mysite.recipesite.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;

    @Column(length = 1000)
    private String ingredients;

    @Column(length = 2000)
    private String steps;

    private int preparationTime; 
    private String difficulty; 

    private String mediaUrl;

    private LocalDate dateAdded;

    private double averageRating;
    private int ratingCount;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;


   
}

