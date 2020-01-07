package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.models.domain.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface UserService {

    ResponseEntity<Object> createUser(User user);

    List<User> readAllUsers();

    User readAUserById(int userId);

    ResponseEntity<Object> updateUser(User user,int id);//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteUser(int userId);


    User findUserByUsername(String username);

    ResponseEntity<User> registration(UserDTO userDTO, BindingResult bindingResult);


}
