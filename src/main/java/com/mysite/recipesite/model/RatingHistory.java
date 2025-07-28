package com.mysite.recipesite.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rating_history")
@Data
public class RatingHistory {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int userid;

    @Column
    private int recipeid;

    @Column(nullable = false)
    private int ratingValue; // 1-5 stars

    @Column(nullable = false)
    private LocalDate ratingDate; // for checking weekly rating

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User userRef;

    @ManyToOne
    @JoinColumn(name = "recipeid", insertable = false, updatable = false)
    private Recipe recipeRef;
}
