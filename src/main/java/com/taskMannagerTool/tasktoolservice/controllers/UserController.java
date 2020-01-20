package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.exceptions.UserException;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@RestController
@Slf4j
public class UserController extends UserServiceImpl{

    @Autowired
    private UserServiceImpl userServiceImpl;

    

    public UserController(UserRepository userRepository) {
        super(userRepository);
    }


    @PostMapping("/registration")
    public ResponseEntity<Object> createUser(@RequestBody User user) throws UserException {
        return userServiceImpl.createUser(user);
    }

    @GetMapping("/users")
    public List<User> readAllUsers() throws UserException {
        return userServiceImpl.readAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User readAUserById(@PathVariable int userId) throws UserException {
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






}
