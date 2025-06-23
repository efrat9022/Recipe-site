// package com.mysite.recipesite.model;

// import jakarta.persistence.*;
// import lombok.Data;

// import java.time.LocalDate;


// @Entity
// @Data
// public class Recipe {

//     @Id
//     @GeneratedValue
//     private int id;

//     private String title;
//     private String description;

//     @Column(length = 1000)
//     private String ingredients;// רכיבים

//     @Column(length = 2000)
//     private String steps;//אופן ההכנה

//     private int preparationTime; 
//     private String difficulty; // רמת קושי

//     private String mediaUrl; // תמונה או סרטון

//     private LocalDate dateAdded;//תאריך הוספה

//     private double averageRating;
//     private int ratingCount;

// @ManyToOne
// @JoinColumn(name = "user_id", nullable = false)
// private User user;


   
// }

package com.mysite.recipesite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id") // זאת העמודה ש-Hibernate יוצר בטבלת recipes
    @JsonIgnoreProperties("recipes") // מונע לולאה בזמן סידור JSON
    private User user;
}
