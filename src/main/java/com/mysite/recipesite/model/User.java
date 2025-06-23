// package com.mysite.recipesite.model;

// import jakarta.persistence.*;
// import lombok.Data;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// @Entity
// @Data
// public class User {

//     @Id
//     @GeneratedValue
//     private Integer  id;

//     @Column
//     private String username;

//     private String password;

//     @OneToMany(mappedBy = "user")
//     @JsonIgnore
//     private List<Recipe> recipes;
// }

package com.mysite.recipesite.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
