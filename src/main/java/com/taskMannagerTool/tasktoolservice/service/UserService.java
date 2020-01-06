package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<Object> createUser(User user);

    List<User> readAllUsers();

    User readAUserById(int userId);

    ResponseEntity<Object> updateUser(User user,int id);//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteUser(int userId);
}
