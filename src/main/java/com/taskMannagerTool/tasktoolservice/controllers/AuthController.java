package com.taskMannagerTool.tasktoolservice.controllers;


import com.taskMannagerTool.tasktoolservice.jwt.JwtRequest;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

   @Autowired
   private AuthServiceImpl authServiceImpl;

   @PostMapping("/login")
   public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{

       return authServiceImpl.createAuthenticationToken(authenticationRequest);
   }


}