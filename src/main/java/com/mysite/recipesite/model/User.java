package com.mysite.recipesite.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "userRef")
    @JsonIgnore
    private List<Recipe> recipes; 

    @OneToMany(mappedBy = "userRef")
    @JsonIgnore
    private List<RatingHistory> ratings;


}
