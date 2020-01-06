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
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


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



    public void deleteUser(int userId){ userRepository.deleteById(userId); }


    public ResponseEntity<Object> createUser(User user) {
        User savedStudent = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getUserId()).toUri();

        return ResponseEntity.created(location).build();

    }


    public ResponseEntity<Object> updateUser(User user, int id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setUserId(id);

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }


}
