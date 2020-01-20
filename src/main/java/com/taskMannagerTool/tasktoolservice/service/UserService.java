package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.exceptions.UserException;
import com.taskMannagerTool.tasktoolservice.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<Object> createUser(User user) throws Exception;

    List<User> readAllUsers() throws UserException;

    Object readAUserById(int userId) throws UserException;

    ResponseEntity<Object> updateUser(User user,int id) throws UserException;//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteUser(int userId);


    User findUserByUsername(String username) throws UserException;




}
