package com.mysite.recipesite.controllers;

import com.mysite.recipesite.model.User;
import com.mysite.recipesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/add")
    public void addUser(@RequestBody User u) {
        us.add(u);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User u) {
        us.update(u);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        us.delete(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return us.getAll();
    }

    @GetMapping("/getByUsername/{username}")
    public User getByUsername(@PathVariable String username) {
        return us.getByUsername(username);
    }
}
