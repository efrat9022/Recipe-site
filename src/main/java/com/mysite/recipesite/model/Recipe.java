package com.mysite.recipesite.model;



import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title; 

    @Column(length = 1000)
    private String description; 

    @Column
    private String ingredients; 

    @Column(length = 2000)
    private String steps; 

    @Column
    private String difficulty; 

    @Column
    private String mediaUrl; 

    @Column(nullable = false)
    private int preparationTime = 0;

    @Column
    private int userid; 

    @ManyToOne
    @JoinColumn(name = "userid",insertable = false, updatable = false)
    private User userRef;

    @OneToMany(mappedBy = "recipeRef")
    private List<RatingHistory> ratings;

}