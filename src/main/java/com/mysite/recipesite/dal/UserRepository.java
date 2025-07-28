package com.mysite.recipesite.dal;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mysite.recipesite.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
 
    public User findByUsername(String username);
    boolean existsByUsername(String username);
}
