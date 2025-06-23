package com.mysite.recipesite.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class RatingHistory {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Recipe recipe;

    private LocalDate dateRated;
}
