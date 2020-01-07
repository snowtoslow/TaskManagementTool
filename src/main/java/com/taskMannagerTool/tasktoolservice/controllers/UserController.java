package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.models.domain.AuthDTO;
import com.taskMannagerTool.tasktoolservice.models.domain.UserDTO;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController extends UserServiceImpl {
    @Autowired
    private UserServiceImpl userServiceImpl;


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userServiceImpl.readAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User readAUserById(@PathVariable int userId) {
        return userServiceImpl.readAUserById(userId);
    }

    @PutMapping("/users/update/{userId}")//добавил апдэйт если что можно удалять
    public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int userId) {
        return userServiceImpl.updateUser(user,userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userServiceImpl.deleteUser(userId);
    }

    @Override
    @PostMapping("/users/registration")
    public ResponseEntity<User> registration(@RequestBody UserDTO userDTO, BindingResult bindingResult) {
        return super.registration(userDTO, bindingResult);
    }





}
