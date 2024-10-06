package com.property.PropertyService.controller;

import com.property.PropertyService.model.SignIn;
import com.property.PropertyService.model.SignUpDTO;
import com.property.PropertyService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpDTO signUpDTO, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        userService.registerUser(signUpDTO);
        return new ResponseEntity<>("user registered successfully!!",HttpStatus.OK);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> login(@Valid @RequestBody SignIn signIn, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        String message = userService.loginUser(signIn);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
