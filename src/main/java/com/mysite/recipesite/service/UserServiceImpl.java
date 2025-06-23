package com.mysite.recipesite.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysite.recipesite.dal.UserRepository;
import com.mysite.recipesite.model.User;

@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private UserRepository userRepository;

     @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setPassword(updatedUser.getPassword());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(int id) {
    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
    } else {
        throw new RuntimeException("Cannot delete – user not found with id: " + id);
    }
  }
}
