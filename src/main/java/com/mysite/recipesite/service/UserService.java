package com.mysite.recipesite.service;

import com.mysite.recipesite.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User createUser(User user);
    User updateUser(int id, User updatedUser);
    void deleteUser(int id);
}
