package com.mysite.recipesite.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer  id;

    @Column
    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Recipe> recipes;
}

