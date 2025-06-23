package com.mysite.recipesite.dal;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mysite.recipesite.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    // התחברות: שם משתמש וסיסמה
    Optional<User> findByUsernameAndPassword(String username, String password);
    // בדיקה אם קיים שם משתמש כלשהו
    boolean existsByUsername(String username);  
}
