package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.RolesRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User readAUserById(int userId){
        Optional<User> user = userRepository.findById(userId);//костыль надо поменять

        if (!user.isPresent()){
            System.out.println("There is no user with such id: "+userId);
        }
        return user.get();
    }


    @Override
    public void deleteUser(int userId){ userRepository.deleteById(userId); }



    @Override
    public ResponseEntity<Object> createUser(User user) {
        User savedStudent = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getUserId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @Override
    public ResponseEntity<Object> updateUser(User user, int id) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setUserId(id);

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }


    @Override
    public User findUserByUsername(String username) {

        Optional<User> user = Optional.ofNullable(userRepository.findUserByUsername(username));//костыль надо поменять

        if (!user.isPresent()){
            System.out.println("There is no user with such id: "+ username);
        }
        return user.get();
    }


/*
    @Override
    public User register(UserDTO userDTO,BindingResult bindingResult) {
        User userExist = userRepository.findUserByUsername(userDTO.getUsername());

        log.info("User:{}",userExist);


        if (userExist != null){
            bindingResult.reject("username");
        }

        if (bindingResult.hasErrors()) {
            System.out.println("Registration process has errors!");
        } else {

            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setUserPassword(userDTO.getPassword());
            user.setUserEmail(userDTO.getEmail());
            user.setName(userDTO.getFirstName());
            user.setSurname(userDTO.getLastName());
            *//*Optional<Role> byId = rolesRepository.findById(userDTO.getRole());*//*
            user.setRoles(rolesRepository.findById(userDTO.getRole()).get());

            log.debug(String.valueOf(bindingResult.getAllErrors()));



            userRepository.save(user);


        }
        return userExist;
    }*/


}

