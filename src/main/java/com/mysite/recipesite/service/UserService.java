package com.mysite.recipesite.service;

import com.mysite.recipesite.model.User;
import java.util.List;


public interface UserService {
 void add(User u);
 void update(User u);
 void delete(int id);
 List<User> getAll();
 User getByUsername(String username);
}
