package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.models.domain.AuthDTO;
import com.taskMannagerTool.tasktoolservice.models.domain.UserDTO;
import com.taskMannagerTool.tasktoolservice.repository.RolesRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public ResponseEntity<User> registration(UserDTO userDTO, BindingResult bindingResult) {
        User userExist = userRepository.findUserByUsername(userDTO.getUsername());

        if (userExist != null){
            bindingResult.reject("username");
        }

        if (bindingResult.hasErrors()) {
            System.out.println("Registration process has errors!");
        } else {

            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setUserPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setUserEmail(userDTO.getEmail());
            user.setName(userDTO.getFirstName());
            user.setSurname(userDTO.getLastName());
            /*Optional<Role> byId = rolesRepository.findById(userDTO.getRole());*/
            user.setRoles(rolesRepository.findById(userDTO.getRole()).get());



            userRepository.save(user);


        }
        return ResponseEntity.accepted().build();
    }

   /* public ResponseEntity login(AuthDTO authDTO) {
        try {
            String username = authDTO.getUsername();
            new UsernamePasswordAuthenticationToken(username, authDTO.getPassword());
            User user = userRepository.findUserByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }


            return ResponseEntity.accepted().build();
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }*/


}

