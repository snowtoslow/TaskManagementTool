package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.exceptions.UserException;
import com.taskMannagerTool.tasktoolservice.jwt.JwtToken;
import com.taskMannagerTool.tasktoolservice.jwt.JwtUserDetailsService;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.RolesRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public List<User> readAllUsers() throws UserException {
        return Optional.of(userRepository.findAll()).orElseThrow(()->new UserException("There is no such entity"));
    }

    @Override
    public User readAUserById(int userId) throws UserException {
        return userRepository.findById(userId).orElseThrow(()->new UserException("There is no user with such ID: "+userId));
    }


    @Override
    public void deleteUser(int userId)  { userRepository.deleteById(userId); }



    @Override
    public ResponseEntity<Object> createUser(User user) throws UserException {


        if (userRepository.findUserByUsername(user.getUsername())!= null) {
            throw new UserException("There is user with such username:" + user.getUsername());
        }else if (userRepository.findUserByUserEmail(user.getUserEmail())!=null){
            throw new UserException("There is user with such email:" + user.getUserEmail());
        }else if (user.getUserEmail()==null){
            throw new UserException("You have missed EMAIL FIELD!!!!!!Please complete it!");
        } else if (user.getUsername()==null){
            throw new UserException("You have missed USERNAME FIELD!!!!!!Please complete it!");
        }

       User savedUser = userRepository.save(user);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserId()).toUri();


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
    public User findUserByUsername(String username) throws UserException {
        return Optional.ofNullable(userRepository.findUserByUsername(username)).orElseThrow(()->new UserException("There is no user with such username" + username));
    }















}

