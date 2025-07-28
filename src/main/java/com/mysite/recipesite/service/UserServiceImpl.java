// UserServiceImpl.java - מימוש לפי הדוגמה של המורה
package com.mysite.recipesite.service;

import com.mysite.recipesite.dal.UserRepository;
import com.mysite.recipesite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public void add(User u) {
        if (userRepo.existsByUsername(u.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        userRepo.save(u);
    }

    @Override
    public void update(User u) {
        if (!userRepo.existsById(u.getId())) {
            throw new RuntimeException("User does not exist");
        }
        userRepo.save(u);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.findByUsername(username);
    }
} 
