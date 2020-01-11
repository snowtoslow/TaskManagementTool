package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.jwt.JwtRequest;
import com.taskMannagerTool.tasktoolservice.jwt.JwtResponse;
import com.taskMannagerTool.tasktoolservice.jwt.JwtToken;
import com.taskMannagerTool.tasktoolservice.jwt.JwtUserDetailsService;
import com.taskMannagerTool.tasktoolservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;


    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;



    @Override
    public void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED" , e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS",e);
        }

    }

    @Override
    public ResponseEntity<?> createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailsService

                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtToken.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
