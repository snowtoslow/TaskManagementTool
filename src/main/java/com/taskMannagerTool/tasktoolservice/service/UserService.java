package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    //если будут ошибки глянуть еще раз код чела из гайда
    public ResponseEntity<Object> createUser(User user){//добавить респонс бади
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{useId}")
                .build(savedUser.getUserId());

        return ResponseEntity.created(location).build();
    }

    //@GetMapping("/user")//Read
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    //Read a specific task by Id;
    //@GetMapping("/user/{id}")
    public User readATaskById(int id){
        Optional<User> user = userRepository.findById(id);//костыль надо поменять

        if (!user.isPresent()){
            System.out.println("There is no user with such id: "+id);
        }
        return user.get();
    }
}
