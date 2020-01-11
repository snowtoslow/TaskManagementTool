package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.jwt.JwtRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    void authenticate(String username,String password) throws Exception;

    ResponseEntity<?> createAuthenticationToken(JwtRequest authenticationRequest) throws Exception;


}
