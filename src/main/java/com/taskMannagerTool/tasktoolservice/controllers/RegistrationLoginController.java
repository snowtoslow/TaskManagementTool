/*
package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.Role;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.models.domain.UserDTO;
import com.taskMannagerTool.tasktoolservice.repository.RolesRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class RegistrationLoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesRepository rolesRepository;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@Valid UserDTO userDTO, BindingResult bindingResult) throws Exception {

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
            */
/*Optional<Role> byId = rolesRepository.findById(userDTO.getRole());*//*

            user.setRoles(rolesRepository.findById(userDTO.getRole()).get());

            userRepository.save(user);


        }
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/username")
    public String currentUserName(Principal principal, Model model) {
        model.addAttribute("loggedinuser", principal.getName());
        return principal.getName();
    }




}
*/
