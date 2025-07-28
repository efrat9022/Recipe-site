// Recipe.java - מייצג מתכון
package com.mysite.recipesite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String title; // שם המתכון

    @Column(length = 1000)
    private String description; // תיאור המתכון

    @Column
    private String ingredients; // רכיבים (מחרוזת מופרדת בפסיקים או פורמט אחר)

    @Column(length = 2000)
    private String steps; // שלבי ההכנה

    @Column
    private String difficulty; // רמת קושי (קל/בינוני/קשה)

    @Column
    private String mediaUrl; // קישור לתמונה או וידאו

    @Column(nullable = false)
    private int preparationTime = 0;

    @Column
    private int userid; // קטגוריה (כגון: קינוחים, ראשונות, עיקריות)

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid",insertable = false, updatable = false)
    private User user; // משתמש שיצר את המתכון

}