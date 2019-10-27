package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){//добавить респонс бади
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
                .build(savedUser.getUserId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")//Read
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    //Read a specific task by Id;
    @GetMapping("/users/{userId}")
    public User readUserById(@PathVariable int userId){
        Optional<User> user = userRepository.findById(userId);//костыль надо поменять

        if (!user.isPresent()){
            System.out.println("There is no user with such id: "+userId);
        }
        return user.get();
    }


    @PutMapping("/users/{userId}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int userId){
        Optional<User>  userOptional = userRepository.findById(userId);

        if(!userOptional.isPresent())
            return ResponseEntity.notFound().build();
        user.setUserId(userId);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userRepository.deleteById(userId);
    }


}
