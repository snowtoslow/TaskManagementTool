package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Object> createUser(User user){//добавить респонс бади
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
                .build(savedUser.getUserId());

        return ResponseEntity.created(location).build();
    }


    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    public User readAUserById(int userId){
        Optional<User> user = userRepository.findById(userId);//костыль надо поменять

        if (!user.isPresent()){
            System.out.println("There is no user with such id: "+userId);
        }
        return user.get();
    }


    public ResponseEntity<Object> updateUser(User user){
        Optional<User> userOptional = userRepository.findById(user.getUserId());

        if(!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    public void deleteUser(int userId){ userRepository.deleteById(userId); }


}
