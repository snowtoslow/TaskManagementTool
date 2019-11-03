package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.service.UserService;
import com.taskMannagerTool.tasktoolservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController implements UserService {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User readAUserById(@PathVariable int userId) {
        return userService.readAUserById(userId);
    }

    @PutMapping("/users/update")
    public ResponseEntity<Object> updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(int userId) {
        userService.deleteUser(userId);
    }

}
