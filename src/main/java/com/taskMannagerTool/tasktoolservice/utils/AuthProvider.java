package com.taskMannagerTool.tasktoolservice.utils;


import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.models.domain.AuthDTO;
import com.taskMannagerTool.tasktoolservice.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private RegistrationServiceImpl registrationServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();


        User user = (User) registrationServiceImpl.loadUserByUsername(username);

        System.out.println("Here is user:"+user);


        if (user != null && (user.getUsername().equals(username))){


            if (!passwordEncoder.matches(password,user.getUserPassword())){
                throw new BadCredentialsException("Wrong Credentials");
            }
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

            return new UsernamePasswordAuthenticationToken(user,password,authorities);

        }
        else
            throw new BadCredentialsException("Username not found");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}


